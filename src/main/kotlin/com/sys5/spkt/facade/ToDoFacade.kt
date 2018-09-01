package com.sys5.spkt.facade

import com.sys5.spkt.entity.ToDo
import com.sys5.spkt.repository.ToDoRepository
import com.sys5.spkt.repository.UserRepository
import com.sys5.spkt.responseformat.todo.AddToDoResponseFormat
import com.sys5.spkt.responseformat.todo.DeleteToDoResponseFormat
import com.sys5.spkt.responseformat.todo.ToDoResponseFormat
import com.sys5.spkt.responseformat.todo.UpdateToDoCompleteFlagResponseFormat
import com.sys5.spkt.responseformat.todo.UpdateToDoTextResponseFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ToDoFacade @Autowired constructor(private val userRepository: UserRepository,
                                        private val todoRepository: ToDoRepository) {

    fun getToDo(userId: Int): ToDoResponseFormat {
      var todoList: MutableList<ToDo> = todoRepository.findByUserId(userId)
      return ToDoResponseFormat(todoList)
    }

    fun addToDo(userId: Int, text: String): AddToDoResponseFormat {
        var t: ToDo = ToDo()
        t.userId = userId
        t.text = text
        var createdToDo: ToDo = todoRepository.save(t)
        return AddToDoResponseFormat(createdToDo)
    }

    fun updateToDoText(id: Int, text: String): UpdateToDoTextResponseFormat {

        todoRepository.updateTextById(id, text)

        var todo: ToDo = todoRepository.findOneById(id)
        return UpdateToDoTextResponseFormat(todo)
    }

    fun updateToDoCompleteFlag(id: Int): UpdateToDoCompleteFlagResponseFormat {
        todoRepository.updateCompleteFlagById(id)
        return UpdateToDoCompleteFlagResponseFormat("OK")
    }

    fun deleteToDo(id: Int): DeleteToDoResponseFormat {
        var t: ToDo = ToDo()
        t.id = id
        todoRepository.delete(t)
        return DeleteToDoResponseFormat("OK")
    }
}