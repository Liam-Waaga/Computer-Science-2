
#include "lle.hpp"
#include "phonebook.hpp"

int main() {

  LinkedList<Phonebook> books;
  books.emplace_back(
    std::string("John Doe"),
    std::string("1600 Pensylvania Ave Washington DC, United States"),
    std::string("jdoe@whitehouse.gov"),
    std::string("+1 (999)-999-1234")
  );

  return 0;
}
