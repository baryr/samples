package com.example.groovyapi.files

/**
 * Created by bary on 2017-09-17.
 */
class FileApi {

    void printFiles() {
        new File(".").eachFile { file ->
            println file
        }
    }

    void printFilesRecursive() {
        new File(".").eachFileRecurse { file ->
            println file
        }
    }

    void printDirs() {
        new File(".").eachDir { dir ->
            println dir
        }
    }

    void printDirsRecursive() {
        new File(".").eachDirRecurse { dir ->
            println dir
        }
    }

    static void main(String[] args) {
        FileApi fileApi = new FileApi()

        println "\nList of files (including dirs)"
        fileApi.printFiles()

        println "\nList of files recursive (including dirs)"
        fileApi.printFilesRecursive()

        println "\nList of directories"
        fileApi.printDirs()

        println "\nList of directories recursive"
        fileApi.printDirsRecursive()
    }
}
