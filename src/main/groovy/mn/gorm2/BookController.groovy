package mn.gorm2

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import static io.micronaut.http.HttpResponse.ok

@Controller("/book")
@Slf4j
class BookController {

    protected final BookService bookService

    BookController(BookService bookService) {
        this.bookService = bookService
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        String message = "Book count: ${bookService.count()}"

        return "OK - ${message}"
    }

    @Get("/create")
    @Transactional(readOnly = true)
    public HttpResponse<String> create(HttpRequest<?> request) {
        Date now = new Date()
        def book = bookService.save("Book-" + now.toString())
        log.info("book created: ${book}")

        return HttpResponse.created(book)
    }
}
