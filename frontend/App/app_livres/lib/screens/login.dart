import 'package:app_livres/screens/home_menu.dart';
import 'package:brasil_fields/brasil_fields.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Login extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 41, 171, 226),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.only(top: 50),
            child: SizedBox(
              width: 200,
              child: Image.asset("assets/img/logo.png"),
            ),
          ),
          Expanded(
              child: Align(
            alignment: Alignment.bottomCenter,
            child: Container(
              decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.only(
                    topRight: Radius.circular(30),
                    topLeft: Radius.circular(30),
                  )),
              height: 450,
              child: ListView(
                children: [
                  Padding(
                    padding: const EdgeInsets.only(left: 25.0),
                    child: Text(
                      "Bem-Vindo ao Livres",
                      style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.only(top: 25.0, right: 25.0, left: 25.0),
                    child: TextField(
                      key: Key('cpf'),
                      inputFormatters: [
                        FilteringTextInputFormatter.digitsOnly,
                        CpfInputFormatter(),
                      ],
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: const BorderRadius.all(
                            const Radius.circular(10.0),
                          ),
                        ),
                        labelText: 'CPF',
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.only(top: 20.0, right: 25.0, left: 25.0),
                    child: TextField(
                      key: Key('senha'),
                      obscureText: true,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: const BorderRadius.all(
                            const Radius.circular(10.0),
                          ),
                        ),
                        labelText: 'Senha',
                      ),
                    ),
                  ),
                  Padding(
                      padding: const EdgeInsets.only(top: 20.0, right: 25.0, left: 25.0),
                      child: Container(
                        child: FlatButton(
                          child: Text(
                            "Acessar",
                            style: TextStyle(color: Colors.white, fontSize: 20),
                          ),
                          onPressed: () {
                            ///TODO Check Login
                            ///TODO If login admin
                            Navigator.push(context, MaterialPageRoute(builder: (context) => HomeMenu()));

                            ///TODO If Login user
                            ///TODO Create Route to User Screen
                          },
                          color: Color.fromARGB(255, 41, 171, 226),
                          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                        ),
                        height: 50,
                      ))
                ],
              ),
            ),
          )),
        ],
      ),
    );
  }
}

// Future navigateToSubPage(context) async {
//   Navigator.push(context, MaterialPageRoute(builder: (context) => HomeMenu()));
// }

Route _createRoute() {
  return PageRouteBuilder(
    pageBuilder: (context, animation, secondaryAnimation) => HomeMenu(),
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
