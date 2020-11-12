import 'package:app_livres/screens/pre_comunidade.dart';
import 'package:flutter/material.dart';

class HomeMenu extends StatefulWidget {
  _HomeMenu createState() => _HomeMenu();
}

class _HomeMenu extends State<HomeMenu> {
  int _currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Align(
            alignment: Alignment.topCenter,
            child: Container(
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.only(
                  bottomRight: Radius.circular(30),
                  bottomLeft: Radius.circular(30),
                ),
                boxShadow: [
                  BoxShadow(
                    color: Colors.grey.withOpacity(0.3),
                    spreadRadius: 5,
                    blurRadius: 7,
                    offset: Offset(0, 3), // changes position of shadow
                  ),
                ],
              ),
              height: 125,
              child: Padding(
                padding: const EdgeInsets.only(top: 20),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      "Seja Bem-Vindo ",
                      textAlign: TextAlign.center,
                      style: TextStyle(fontWeight: FontWeight.w200, fontSize: 20),
                    ),
                    Text(
                      " Usuário",
                      textAlign: TextAlign.center,
                      style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
                    ),
                    Text(
                      "!",
                      textAlign: TextAlign.center,
                      style: TextStyle(fontWeight: FontWeight.w200, fontSize: 20),
                    ),
                  ],
                ),
              ),
            ),
          ),
          Expanded(
            child: Align(
                alignment: Alignment.bottomCenter,
                child: Container(
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      Column(
                        children: [
                          IconButton(
                            icon: Icon(Icons.group),
                            color: Colors.white,
                            iconSize: 25,
                            onPressed: () {
                              Navigator.of(context).push(_createRoute(PreComunidadeScreen()));
                            },
                          ),
                          Container(
                            child: Text(
                              "Pré-Comunidades",
                              style: TextStyle(fontSize: 14, color: Colors.white, fontWeight: FontWeight.bold),
                            ),
                          )
                        ],
                      ),
                      Column(
                        children: [
                          IconButton(
                            icon: Icon(Icons.person),
                            color: Colors.white,
                            iconSize: 25,
                            onPressed: () {},
                          ),
                          Container(
                            child: Text(
                              "Usuários",
                              style: TextStyle(fontSize: 14, color: Colors.white, fontWeight: FontWeight.bold),
                            ),
                          )
                        ],
                      ),
                      Column(
                        children: [
                          IconButton(
                            icon: Icon(Icons.person),
                            color: Colors.white,
                            iconSize: 25,
                            onPressed: () {},
                          ),
                          Container(
                            child: Text(
                              "Produtores",
                              style: TextStyle(fontSize: 14, color: Colors.white, fontWeight: FontWeight.bold),
                            ),
                          )
                        ],
                      ),
                      Column(
                        children: [
                          IconButton(
                            icon: Icon(Icons.fastfood),
                            color: Colors.white,
                            iconSize: 25,
                            onPressed: () {},
                          ),
                          Container(
                            child: Text(
                              "Produtos",
                              style: TextStyle(fontSize: 14, color: Colors.white, fontWeight: FontWeight.bold),
                            ),
                          )
                        ],
                      ),
                    ],
                  ),
                  height: 80,
                  decoration: BoxDecoration(color: Color.fromARGB(255, 41, 171, 226), borderRadius: BorderRadius.circular(10)),
                )),
          )
        ],
      ),
      /*bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        onTap: (int index) {
          setState(() {
            _currentIndex = index;
          });
        },
        type: BottomNavigationBarType.fixed,
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.group),
            label: "Pré-Comunidades",
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: "Consumidores",
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.food_bank),
            label: "Produtores",
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.fastfood),
            label: "Produtos",
          ),
        ],
        backgroundColor: Color.fromARGB(255, 41, 171, 226),
        fixedColor: Colors.white,
        unselectedItemColor: Colors.white,
      ),*/
    );
  }
}

Route _createRoute(page) {
  return PageRouteBuilder(
    pageBuilder: (context, animation, secondaryAnimation) => page,
    transitionsBuilder: (context, animation, secondaryAnimation, child) {
      var begin = Offset(0.0, 1.0);
      var end = Offset.zero;
      var curve = Curves.ease;

      var tween = Tween(begin: begin, end: end).chain(CurveTween(curve: curve));

      return SlideTransition(
        position: animation.drive(tween),
        child: child,
      );
    },
  );
}
