

#include <string>

class Phonebook {
public:
  Phonebook(std::string name, std::string address, std::string email,
            std::string cellnumber);

private:
  std::string _name, _address, _email, _cellnumber;
};
