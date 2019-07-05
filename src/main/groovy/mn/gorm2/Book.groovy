package mn.gorm2

import grails.gorm.annotation.Entity
import groovy.transform.ToString

@Entity
@ToString
class Book {
    String title
}
