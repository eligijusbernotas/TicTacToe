# TicTacToe
Programų sistemų projektavimo 1 užduotis.

Changelog

Update 1 (2018/12/14):
-Nauja klasė Player, kuri laikys žaidėjo symbolį (pvz. X arba O) ir pergalių skaičių.
-Nauja klasė HumanPlayer, kuri paveldi Player klasę ir turi Name kintamajį. Ateityje gal bus pridėta ComputerPlayer.
-Nauja TileMap klasė, prieš tai tiesiog kintamasis, laiko Tic Tac Toe lentos išmatavimus(pvz. 3x3) ir dvimati masyvą. Ši klasė yra žaidimo lenta, gali būti pernaudota kitiems žaidimams, kurie naudojasi žaidimų lenta.
-Nauja TileMapPrinter klasė, kuri atvaizduoja lentą konsolėje. Vaizdavimo formatas dabar yra Tic Tac Toe žaidimui, galima pakeisti į kitų žaidimų lentas sukuriant naują metodą.
-Nauja InputScanner klasė, kuri valdo Tic Tac Toe žaidimo įvedimą, tikrindama reikalingus kriterijus.
-Nauja TicTacToe klasė, kuri laiko visą Tic Tac Toe žaidimo logiką.
-Nauja GameRunner klasė, kuri paleidžia programą. Ji laiko du žaidėjus ir žaidimus. Universali, galimybė naudoti šia klasę su dauguma dviejų ar vieno žaidėjo žaidimais, kurie naudojasi žaidimo lenta.
