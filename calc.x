struct dupla_int {
    int x;
    int y;
};

program CALC_PROG {
    version CALC_VERS {
        int suma(dupla_int) = 1;
        int resta(dupla_int) = 2;
        int multiplicacion(dupla_int) = 3;
        int division(dupla_int) = 4;
    } = 1;
} = 0x20000001;