package me.saket.press.shared.editor

// Specs for client apps to implement:
//
// - Capitalize the first letter of a heading. See `CapitalizeOnHeadingStart`.
//
// - When a link is clicked, show a menu for letting the user actually open
//   the Url or place the cursor on the Url for editing it.
//
// - Remove rich text formatting when pasting text. See `WysiwygEditText`.
//   On Android, copying a URL will implicitly also copy its underline
//   span, which we don't want.
interface EditorEvent {
  data class NoteTextChanged(val text: String) : EditorEvent
}

data class EditorUiModel(
  val hintText: String?
)

sealed class EditorUiEffect {
  data class PopulateContent(
    val content: String,
    val moveCursorToEnd: Boolean
  ) : EditorUiEffect()

  object CloseNote : EditorUiEffect()
}