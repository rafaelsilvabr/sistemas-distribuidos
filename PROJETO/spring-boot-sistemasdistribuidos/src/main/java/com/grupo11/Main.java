package com.grupo11;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("api/v1/tickets")
public class Main {
    private  final TicketRepository ticketRepository;

    public Main(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping
    public List<Ticket> getTicket(){
        return ticketRepository.findAll();
    }

    record NewTicketRequest(
            String nomeSolicitante,
            String descricao,
            String endereco,
            String status
    ){}

    @PostMapping
    public void addTicket(@RequestBody NewTicketRequest request){
            Ticket ticket = new Ticket();
            ticket.setNomeSolicitante(request.nomeSolicitante());
            ticket.setDescricao(request.descricao());
            ticket.setEndereco(request.endereco());
            ticket.setStatus(request.status());

            ticketRepository.save(ticket);
    }

    @DeleteMapping
    public void deleteTicket(Integer id){
        ticketRepository.deleteById(id);
    }

    
}


