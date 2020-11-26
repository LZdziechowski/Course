package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private final OrderService orderService;
    private final InformationService informationService;
    private final OrderRepository orderRepository;

    public ProductOrderService(final OrderService orderService,final InformationService informationService,final OrderRepository orderRepository) {
        this.orderService = orderService;
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {

        final boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());

        if(isOrdered) {
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            informationService.inform(orderRequest.getUser());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
