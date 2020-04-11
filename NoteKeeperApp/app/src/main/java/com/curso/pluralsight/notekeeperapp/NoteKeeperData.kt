package com.curso.pluralsight.notekeeperapp

data class CourseInfo(val courseId: String, val title: String) {

    //Se sobrescrever o método toString() quando mostrar os dados do curso no Spinner, mostrará apenas
    // o título. Se não fizer isso, ele mostra a classe CourseInfo sem formatar, então fica com o
    // valor do package...
    override fun toString(): String {
        return title
    }
}

//Colocando como data class, ele cria o toString() automaticamente para nós. Mas também cria outros
// métodos como o equals() e o hashcode(). Se criarmos manualmente alguns desse métodos, ele
// simplesmente ignora a criação automática desse método em específico.
//Colocando as interrogações, eu permito que se crie essa classe com valores nulos.
//Também posso definir os valores como null
data class NoteInfo(var course: CourseInfo? = null, var title: String? = null, var text: String? = null)