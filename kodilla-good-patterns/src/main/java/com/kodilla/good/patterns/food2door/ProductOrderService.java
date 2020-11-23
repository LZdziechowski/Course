package com.kodilla.good.patterns.food2door;

public class ProductOrderService {

    private final OrderService orderService;
    private final InformationService informationService;
    private final OrderRepository orderRepository;

    public ProductOrderService(final OrderService orderService, final InformationService informationService, final OrderRepository orderRepository) {
        this.orderService = orderService;
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO process(final OrderRequest orderRequest) {

        final boolean isOrdered = orderService.order(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQuantity());

        if (isOrdered) {
            informationService.inform(orderRequest.getSupplier());
            orderRepository.createOrder(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDTO(orderRequest.getSupplier(), true);
        } else {
            return new OrderDTO(orderRequest.getSupplier(), false);
        }
    }
}

