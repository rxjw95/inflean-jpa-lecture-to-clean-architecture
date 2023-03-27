package com.example.infleanjpalecture.order.application;

import com.example.infleanjpalecture.item.application.port.out.ItemLoadPort;
import com.example.infleanjpalecture.item.domain.Book;
import com.example.infleanjpalecture.member.application.usecase.out.MemberLoadPort;
import com.example.infleanjpalecture.member.domain.Member;
import com.example.infleanjpalecture.order.application.port.dto.OrderItemDto;
import com.example.infleanjpalecture.order.application.port.dto.OrderMemberDto;
import com.example.infleanjpalecture.order.application.port.dto.SalesView;
import com.example.infleanjpalecture.order.application.port.in.SalesLoadUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SalesLoadService implements SalesLoadUseCase {
    private final MemberLoadPort memberLoadPort;
    private final ItemLoadPort itemLoadPort;
    private final DtoConverter dtoConverter;

    public SalesLoadService(MemberLoadPort memberLoadPort, ItemLoadPort itemLoadPort, DtoConverter dtoConverter) {
        this.memberLoadPort = memberLoadPort;
        this.itemLoadPort = itemLoadPort;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public SalesView loadAll() {
        List<Member> members = memberLoadPort.loadAll();
        List<Book> books = itemLoadPort.loadAll();

        List<OrderMemberDto> orderMemberDtos = dtoConverter.toOrderMemberDtos(members);
        List<OrderItemDto> orderItemDtos = dtoConverter.toOrderItemDtos(books);

        return dtoConverter.toSalesView(orderMemberDtos, orderItemDtos);
    }
}
