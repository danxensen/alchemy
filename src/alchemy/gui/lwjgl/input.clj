(ns alchemy.gui.lwjgl.input
  (:import [org.lwjgl.input Keyboard]))

(def convert-keys
  {Keyboard/KEY_0 :key-0
   Keyboard/KEY_1 :key-1
   Keyboard/KEY_2 :key-2
   Keyboard/KEY_3 :key-3
   Keyboard/KEY_4 :key-4
   Keyboard/KEY_5 :key-5
   Keyboard/KEY_6 :key-6
   Keyboard/KEY_7 :key-7
   Keyboard/KEY_8 :key-8
   Keyboard/KEY_9 :key-9
   Keyboard/KEY_A :key-a
   Keyboard/KEY_APOSTROPHE :key-apostrophe
   Keyboard/KEY_APPS :key-apps
   Keyboard/KEY_AT :key-at
   Keyboard/KEY_AX :key-ax
   Keyboard/KEY_B :key-b
   Keyboard/KEY_BACK :key-back
   Keyboard/KEY_BACKSLASH :key-backslash
   Keyboard/KEY_C :key-c
   Keyboard/KEY_CAPITAL :key-capital
   Keyboard/KEY_CIRCUMFLEX :key-circumflex
   Keyboard/KEY_CLEAR :key-clear
   Keyboard/KEY_COLON :key-colon
   Keyboard/KEY_COMMA :key-comma
   Keyboard/KEY_CONVERT :key-convert
   Keyboard/KEY_D :key-d
   Keyboard/KEY_DECIMAL :key-decimal
   Keyboard/KEY_DELETE :key-delete
   Keyboard/KEY_DIVIDE :key-divide
   Keyboard/KEY_DOWN :key-down
   Keyboard/KEY_E :key-e
   Keyboard/KEY_END :key-end
   Keyboard/KEY_EQUALS :key-equals
   Keyboard/KEY_ESCAPE :key-escape
   Keyboard/KEY_F :key-f
   Keyboard/KEY_F1 :key-f1
   Keyboard/KEY_F2 :key-f2
   Keyboard/KEY_F3 :key-f3
   Keyboard/KEY_F4 :key-f4
   Keyboard/KEY_F5 :key-f5
   Keyboard/KEY_F6 :key-f6
   Keyboard/KEY_F7 :key-f7
   Keyboard/KEY_F8 :key-f8
   Keyboard/KEY_F9 :key-f9
   Keyboard/KEY_F10 :key-f10
   Keyboard/KEY_F11 :key-f11
   Keyboard/KEY_F12 :key-f12
   Keyboard/KEY_F13 :key-f13
   Keyboard/KEY_F14 :key-f14
   Keyboard/KEY_F15 :key-f15
   Keyboard/KEY_F16 :key-f16
   Keyboard/KEY_F17 :key-f17
   Keyboard/KEY_F18 :key-f18
   Keyboard/KEY_F19 :key-f19
   Keyboard/KEY_FUNCTION :key-function
   Keyboard/KEY_G :key-g
   Keyboard/KEY_GRAVE :key-grave
   Keyboard/KEY_H :key-h
   Keyboard/KEY_HOME :key-home
   Keyboard/KEY_I :key-i
   Keyboard/KEY_INSERT :key-insert
   Keyboard/KEY_J :key-j
   Keyboard/KEY_K :key-k
   Keyboard/KEY_KANA :key-kana
   Keyboard/KEY_KANJI :key-kanji
   Keyboard/KEY_L :key-l
   Keyboard/KEY_LBRACKET :key-lbracket
   Keyboard/KEY_LCONTROL :key-lcontrol
   Keyboard/KEY_LEFT :key-left
   Keyboard/KEY_LMENU :key-menu
   Keyboard/KEY_LMETA :key-lmeta
   Keyboard/KEY_LSHIFT :key-lshift
   Keyboard/KEY_M :key-m
   Keyboard/KEY_MINUS :key-minus
   Keyboard/KEY_MULTIPLY :key-multiply
   Keyboard/KEY_N :key-n
   Keyboard/KEY_NEXT :key-next
   Keyboard/KEY_NOCONVERT :key-noconvert
   Keyboard/KEY_NONE :key-none
   Keyboard/KEY_NUMLOCK :key-numlock
   Keyboard/KEY_NUMPAD0 :key-numpad0
   Keyboard/KEY_NUMPAD1 :key-numpad1
   Keyboard/KEY_NUMPAD2 :key-numpad2
   Keyboard/KEY_NUMPAD3 :key-numpad3
   Keyboard/KEY_NUMPAD4 :key-numpad4
   Keyboard/KEY_NUMPAD5 :key-numpad5
   Keyboard/KEY_NUMPAD6 :key-numpad6
   Keyboard/KEY_NUMPAD7 :key-numpad7
   Keyboard/KEY_NUMPAD8 :key-numpad8
   Keyboard/KEY_NUMPAD9 :key-numpad9
   Keyboard/KEY_NUMPADCOMMA :key-numpadcomma
   Keyboard/KEY_NUMPADENTER :key-numpadenter
   Keyboard/KEY_NUMPADEQUALS :key-numpadequals
   Keyboard/KEY_O :key-o
   Keyboard/KEY_P :key-p
   Keyboard/KEY_PAUSE :key-pause
   Keyboard/KEY_PERIOD :key-period
   Keyboard/KEY_POWER :key-power
   Keyboard/KEY_PRIOR :key-prior
   Keyboard/KEY_Q :key-q
   Keyboard/KEY_R :key-r
   Keyboard/KEY_RBRACKET :key-rbracket
   Keyboard/KEY_RCONTROL :key-rcontrol
   Keyboard/KEY_RETURN :key-return
   Keyboard/KEY_RIGHT :key-right
   Keyboard/KEY_RMENU :key-rmenu
   Keyboard/KEY_RMETA :key-rmeta
   Keyboard/KEY_RSHIFT :key-rshift
   Keyboard/KEY_S :key-s
   Keyboard/KEY_SCROLL :key-scroll
   Keyboard/KEY_SECTION :key-section
   Keyboard/KEY_SEMICOLON :key-semicolon
   Keyboard/KEY_SLASH :key-slash
   Keyboard/KEY_SLEEP :key-sleep
   Keyboard/KEY_SPACE :key-space
   Keyboard/KEY_STOP :key-stop
   Keyboard/KEY_SUBTRACT :key-subtract
   Keyboard/KEY_SYSRQ :key-sysrq
   Keyboard/KEY_T :key-t
   Keyboard/KEY_TAB :key-tab
   Keyboard/KEY_U :key-u
   Keyboard/KEY_UNDERLINE :key-underline
   Keyboard/KEY_UNLABELED :key-unlabeled
   Keyboard/KEY_UP :key-up
   Keyboard/KEY_V :key-v
   Keyboard/KEY_W :key-w
   Keyboard/KEY_X :key-x
   Keyboard/KEY_Y :key-y
   Keyboard/KEY_YEN :key-yen
   Keyboard/KEY_Z :key-z})

(defn keyboard-events
  "gets the keyboard inputs from event buffer"
  []
  (loop [more? (Keyboard/next)
         events []]
    (if more?
      (let [pressed? (Keyboard/getEventKeyState)
            lwjgl-key (Keyboard/getEventKey)
            key (convert-keys lwjgl-key)
            time (Keyboard/getEventNanoseconds) ; convert to milliseconds?
            events (conj events {:pressed? pressed?
                                 :key key
                                 :time time})]
        (recur (Keyboard/next) events))
      events)))

;; to-do: add mouse support once i figure out how it should work
