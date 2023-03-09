package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.item.domain.Book;
import com.example.infleanjpalecture.member.domain.Member;
import com.example.infleanjpalecture.order.application.port.dto.OrderHistoryView;
import com.example.infleanjpalecture.order.application.port.dto.OrderItemDto;
import com.example.infleanjpalecture.order.application.port.dto.OrderMemberDto;
import com.example.infleanjpalecture.order.application.port.dto.SalesView;
import com.example.infleanjpalecture.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoConverter {

    public SalesView toSalesView(List<OrderMemberDto> orderMembers, List<OrderItemDto> orderItems) {
        return new SalesView(orderMembers, orderItems);
    }

    public List<OrderHistoryView> toOrderHistoryViews(List<Order> orders) {
        return orders.stream().map(this::toOrderHistoryView).toList();
    }

    public OrderHistoryView toOrderHistoryView(Order order) {
        return new OrderHistoryView(
                order.getOrderId(),
                order.getMember().getName(),
                order.getOrderItems().get(0).getItem().getName(),
                order.getTotalPrice().toIntValue(),
                order.getOrderItems().get(0).getCount(),
                order.getStatus().toString(),
                order.getOrderDate());
    }

    public List<OrderMemberDto> toOrderMemberDtos(List<Member> members) {
        return members.stream().map(this::toOrderMemberDto).toList();
    }

    public OrderMemberDto toOrderMemberDto(Member member) {
        return new OrderMemberDto(member.getMemberId(), member.getName());
    }

    public List<OrderItemDto> toOrderItemDtos(List<Book> books) {
        return books.stream().map(this::toOrderItemDto).toList();
    }

    public OrderItemDto toOrderItemDto(Book book) {
        return new OrderItemDto(book.getItemId(), book.getName());
    }
}
