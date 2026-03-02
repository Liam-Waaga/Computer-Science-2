
#pragma once

#include <memory>

template <typename T> class LinkedListElement {

public:
  template <typename... Args>
  LinkedListElement(std::weak_ptr<LinkedListElement<T>> prev,
                    std::shared_ptr<LinkedListElement<T>> next, Args &&...args)
      : _next{next},
        _obj{std::make_shared<T>(std::forward<Args>(args)...)} {}

  ~LinkedListElement() {}

  std::shared_ptr<T> &get() { return this->_obj; }

  template <typename... Args> T set(Args &&...args) {
    this->_obj = std::make_shared<T>(std::forward<Args>(args)...);
  }

  std::shared_ptr<LinkedListElement<T>> next() { return this->_next; }

  /* construct an element after */
  template <typename... Args> void push_next(Args &&...args) {
    std::shared_ptr<LinkedListElement<T>> tmp =
        std::make_shared<LinkedListElement<T>>(std::forward<Args>(args)...);
  }

  void set_next(std::shared_ptr<LinkedListElement<T>> next) {
    this->_next = next;
  }

private:
  /* shared_ptr to not deal with ref counting and stuff */
  std::shared_ptr<T> _obj;

  std::shared_ptr<LinkedListElement<T>> _next = nullptr;
};

template <typename T> class LinkedList {
public:
  LinkedList() { _head = nullptr; }

  template <typename... Args> void emplace_back(Args &&...args) {
    if (_head == nullptr) {
      /* make it if it is empty */
      _head =
          std::make_shared<LinkedListElement<T>>(std::forward<Args>(args)...);
    } else {
      std::shared_ptr<LinkedListElement<T>> tmp = _head;
      /* get the last obj */
      while (tmp->next() != nullptr) {
        tmp = tmp->next();
      }
      tmp->push_next(std::forward<Args>(args)...);
    }
  }

  std::shared_ptr<T> &operator[](long long index) {
    std::shared_ptr<LinkedListElement<T>> tmp = _head;
    while (--index) tmp = tmp->next();
    return tmp->get();
  }

private:
  std::shared_ptr<LinkedListElement<T>> _head;
};
