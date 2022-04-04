#include <iostream>
using namespace std;

//类模板对象做函数参数
template <class T1, class T2>
class Person
{
public:
    Person(T1 name, T2 age)
    {
        this->m_Name = name;
        this->m_Age = age;
    }

    void showPerson()
    {
        cout << "姓名：" << this->m_Name << " "
             << "年龄：" << this->m_Age << endl;
    }

    T1 m_Name;
    T2 m_Age;
};

//指定传入类型
void printPerson1(Person<string, int> &p)
{
    p.showPerson();
}

void test01()
{
    Person<string, int> p("杨间", 23);
    printPerson1(p);
}

//参数模板化
template <class T1, class T2>
void printPerson2(Person<T1, T2> &p)
{
    p.showPerson();
    cout << "T1的数据类型为：" << typeid(T1).name() << endl;
    cout << "T2的数据类型为：" << typeid(T2).name() << endl;
}

void test02()
{
    Person<string, int> p("杨间", 23);
    printPerson2(p);
}

//整个类模板化
template <class T>
void printPerson3(T &p)
{
    p.showPerson();
    cout << "T的数据类型为：" << typeid(T).name() << endl;
}

void test03()
{
    Person<string, int> p("杨间", 23);
    printPerson3(p);
}

int main()
{
    // test01();
    // test02();
    test03();
    return 0;
}