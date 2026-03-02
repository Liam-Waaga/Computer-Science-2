

#include "phonebook.hpp"

Phonebook::Phonebook(std::string name, std::string address, std::string email,
                     std::string cellnumber)
    : _name{name}, _address{address}, _email{email}, _cellnumber{cellnumber} {}
