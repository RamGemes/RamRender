package ramgames.ramrender.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public interface KeyboardController extends KeyListener {

    Set<Integer> activeKeys = new HashSet<>();

    @Override
    default void keyTyped(KeyEvent keyEvent) {
        // IDK why this even exists. It is the same as keyPressed()
    }

    @Override
    default void keyPressed(KeyEvent keyEvent) {

        if(!activeKeys.contains(keyEvent.getKeyCode())) {
            activeKeys.add(keyEvent.getKeyCode());
            onPressRouter(keyEvent);
            return;
        }
        onHoldRouter(keyEvent);
    }

    @Override
    default void keyReleased(KeyEvent keyEvent) {
        this.activeKeys.remove(keyEvent.getKeyCode());
        onReleaseRouter(keyEvent);
    }

    default void onPressRouter(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case 8  -> onPress_BACKSPACE(keyEvent);
            case 9  -> onPress_TAB(keyEvent);
            case 10  -> onPress_ENTER(keyEvent);
            case 12  -> onPress_CLEAR(keyEvent);
            case 16  -> onPress_SHIFT(keyEvent);
            case 17  -> onPress_CTRL(keyEvent);
            case 18  -> onPress_ALT(keyEvent);
            case 19  -> onPress_PAUSE(keyEvent);
            case 20  -> onPress_CAPS_LOCK(keyEvent);
            case 27  -> onPress_ESCAPE(keyEvent);
            case 28  -> onPress_CONVERT(keyEvent);
            case 30  -> onPress_ACCEPT(keyEvent);
            case 32  -> onPress_SPACE(keyEvent);
            case 33  -> onPress_PAGE_UP(keyEvent);
            case 34  -> onPress_PAGE_DOWN(keyEvent);
            case 35  -> onPress_END(keyEvent);
            case 36  -> onPress_HOME(keyEvent);
            case 37  -> onPress_LEFT(keyEvent);
            case 38  -> onPress_UP(keyEvent);
            case 39  -> onPress_RIGHT(keyEvent);
            case 40  -> onPress_DOWN(keyEvent);
            case 44  -> onPress_COMMA(keyEvent);
            case 45  -> onPress_MINUS(keyEvent);
            case 46  -> onPress_PERIOD(keyEvent);
            case 47  -> onPress_SLASH(keyEvent);
            case 48  -> onPress_0(keyEvent);
            case 49  -> onPress_1(keyEvent);
            case 50  -> onPress_2(keyEvent);
            case 51  -> onPress_3(keyEvent);
            case 52  -> onPress_4(keyEvent);
            case 53  -> onPress_5(keyEvent);
            case 54  -> onPress_6(keyEvent);
            case 55  -> onPress_7(keyEvent);
            case 56  -> onPress_8(keyEvent);
            case 57  -> onPress_9(keyEvent);
            case 59  -> onPress_SEMICOLON(keyEvent);
            case 61  -> onPress_EQUALS(keyEvent);
            case 65  -> onPress_A(keyEvent);
            case 66  -> onPress_B(keyEvent);
            case 67  -> onPress_C(keyEvent);
            case 68  -> onPress_D(keyEvent);
            case 69  -> onPress_E(keyEvent);
            case 70  -> onPress_F(keyEvent);
            case 71  -> onPress_G(keyEvent);
            case 72  -> onPress_H(keyEvent);
            case 73  -> onPress_I(keyEvent);
            case 74  -> onPress_J(keyEvent);
            case 75  -> onPress_K(keyEvent);
            case 76  -> onPress_L(keyEvent);
            case 77  -> onPress_M(keyEvent);
            case 78  -> onPress_N(keyEvent);
            case 79  -> onPress_O(keyEvent);
            case 80  -> onPress_P(keyEvent);
            case 81  -> onPress_Q(keyEvent);
            case 82  -> onPress_R(keyEvent);
            case 83  -> onPress_S(keyEvent);
            case 84  -> onPress_T(keyEvent);
            case 85  -> onPress_U(keyEvent);
            case 86  -> onPress_V(keyEvent);
            case 87  -> onPress_W(keyEvent);
            case 88  -> onPress_X(keyEvent);
            case 89  -> onPress_Y(keyEvent);
            case 90  -> onPress_Z(keyEvent);
            case 91  -> onPress_OPEN_BRACKET(keyEvent);
            case 92  -> onPress_BACK_SLASH(keyEvent);
            case 93  -> onPress_CLOSE_BRACKET(keyEvent);
            case 96  -> onPress_NUMPAD_0(keyEvent);
            case 97  -> onPress_NUMPAD_1(keyEvent);
            case 98  -> onPress_NUMPAD_2(keyEvent);
            case 99  -> onPress_NUMPAD_3(keyEvent);
            case 100  -> onPress_NUMPAD_4(keyEvent);
            case 101  -> onPress_NUMPAD_5(keyEvent);
            case 102  -> onPress_NUMPAD_6(keyEvent);
            case 103  -> onPress_NUMPAD_7(keyEvent);
            case 104  -> onPress_NUMPAD_8(keyEvent);
            case 105  -> onPress_NUMPAD_9(keyEvent);
            case 106  -> onPress_NUMPAD_STAR(keyEvent);
            case 107  -> onPress_NUMPAD_PLUS(keyEvent);
            case 108  -> onPress_NUMPAD_COMMA(keyEvent);
            case 109  -> onPress_NUMPAD_DASH(keyEvent);
            case 110  -> onPress_NUMPAD_PERIOD(keyEvent);
            case 111  -> onPress_NUMPAD_SLASH(keyEvent);
            case 112  -> onPress_F1(keyEvent);
            case 113  -> onPress_F2(keyEvent);
            case 114  -> onPress_F3(keyEvent);
            case 115  -> onPress_F4(keyEvent);
            case 116  -> onPress_F5(keyEvent);
            case 117  -> onPress_F6(keyEvent);
            case 118  -> onPress_F7(keyEvent);
            case 119  -> onPress_F8(keyEvent);
            case 120  -> onPress_F9(keyEvent);
            case 121  -> onPress_F10(keyEvent);
            case 122  -> onPress_F11(keyEvent);
            case 123  -> onPress_F12(keyEvent);
            case 127  -> onPress_DELETE(keyEvent);
            case 192  -> onPress_BACK_QUOTE(keyEvent);
            case 222  -> onPress_QUOTE(keyEvent);
        }
    }


    default void onHoldRouter(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case 8  -> onHold_BACKSPACE(keyEvent);
            case 9  -> onHold_TAB(keyEvent);
            case 10  -> onHold_ENTER(keyEvent);
            case 12  -> onHold_CLEAR(keyEvent);
            case 16  -> onHold_SHIFT(keyEvent);
            case 17  -> onHold_CTRL(keyEvent);
            case 18  -> onHold_ALT(keyEvent);
            case 19  -> onHold_PAUSE(keyEvent);
            case 20  -> onHold_CAPS_LOCK(keyEvent);
            case 27  -> onHold_ESCAPE(keyEvent);
            case 28  -> onHold_CONVERT(keyEvent);
            case 30  -> onHold_ACCEPT(keyEvent);
            case 32  -> onHold_SPACE(keyEvent);
            case 33  -> onHold_PAGE_UP(keyEvent);
            case 34  -> onHold_PAGE_DOWN(keyEvent);
            case 35  -> onHold_END(keyEvent);
            case 36  -> onHold_HOME(keyEvent);
            case 37  -> onHold_LEFT(keyEvent);
            case 38  -> onHold_UP(keyEvent);
            case 39  -> onHold_RIGHT(keyEvent);
            case 40  -> onHold_DOWN(keyEvent);
            case 44  -> onHold_COMMA(keyEvent);
            case 45  -> onHold_MINUS(keyEvent);
            case 46  -> onHold_PERIOD(keyEvent);
            case 47  -> onHold_SLASH(keyEvent);
            case 48  -> onHold_0(keyEvent);
            case 49  -> onHold_1(keyEvent);
            case 50  -> onHold_2(keyEvent);
            case 51  -> onHold_3(keyEvent);
            case 52  -> onHold_4(keyEvent);
            case 53  -> onHold_5(keyEvent);
            case 54  -> onHold_6(keyEvent);
            case 55  -> onHold_7(keyEvent);
            case 56  -> onHold_8(keyEvent);
            case 57  -> onHold_9(keyEvent);
            case 59  -> onHold_SEMICOLON(keyEvent);
            case 61  -> onHold_EQUALS(keyEvent);
            case 65  -> onHold_A(keyEvent);
            case 66  -> onHold_B(keyEvent);
            case 67  -> onHold_C(keyEvent);
            case 68  -> onHold_D(keyEvent);
            case 69  -> onHold_E(keyEvent);
            case 70  -> onHold_F(keyEvent);
            case 71  -> onHold_G(keyEvent);
            case 72  -> onHold_H(keyEvent);
            case 73  -> onHold_I(keyEvent);
            case 74  -> onHold_J(keyEvent);
            case 75  -> onHold_K(keyEvent);
            case 76  -> onHold_L(keyEvent);
            case 77  -> onHold_M(keyEvent);
            case 78  -> onHold_N(keyEvent);
            case 79  -> onHold_O(keyEvent);
            case 80  -> onHold_P(keyEvent);
            case 81  -> onHold_Q(keyEvent);
            case 82  -> onHold_R(keyEvent);
            case 83  -> onHold_S(keyEvent);
            case 84  -> onHold_T(keyEvent);
            case 85  -> onHold_U(keyEvent);
            case 86  -> onHold_V(keyEvent);
            case 87  -> onHold_W(keyEvent);
            case 88  -> onHold_X(keyEvent);
            case 89  -> onHold_Y(keyEvent);
            case 90  -> onHold_Z(keyEvent);
            case 91  -> onHold_OPEN_BRACKET(keyEvent);
            case 92  -> onHold_BACK_SLASH(keyEvent);
            case 93  -> onHold_CLOSE_BRACKET(keyEvent);
            case 96  -> onHold_NUMPAD_0(keyEvent);
            case 97  -> onHold_NUMPAD_1(keyEvent);
            case 98  -> onHold_NUMPAD_2(keyEvent);
            case 99  -> onHold_NUMPAD_3(keyEvent);
            case 100  -> onHold_NUMPAD_4(keyEvent);
            case 101  -> onHold_NUMPAD_5(keyEvent);
            case 102  -> onHold_NUMPAD_6(keyEvent);
            case 103  -> onHold_NUMPAD_7(keyEvent);
            case 104  -> onHold_NUMPAD_8(keyEvent);
            case 105  -> onHold_NUMPAD_9(keyEvent);
            case 106  -> onHold_NUMPAD_STAR(keyEvent);
            case 107  -> onHold_NUMPAD_PLUS(keyEvent);
            case 108  -> onHold_NUMPAD_COMMA(keyEvent);
            case 109  -> onHold_NUMPAD_DASH(keyEvent);
            case 110  -> onHold_NUMPAD_PERIOD(keyEvent);
            case 111  -> onHold_NUMPAD_SLASH(keyEvent);
            case 112  -> onHold_F1(keyEvent);
            case 113  -> onHold_F2(keyEvent);
            case 114  -> onHold_F3(keyEvent);
            case 115  -> onHold_F4(keyEvent);
            case 116  -> onHold_F5(keyEvent);
            case 117  -> onHold_F6(keyEvent);
            case 118  -> onHold_F7(keyEvent);
            case 119  -> onHold_F8(keyEvent);
            case 120  -> onHold_F9(keyEvent);
            case 121  -> onHold_F10(keyEvent);
            case 122  -> onHold_F11(keyEvent);
            case 123  -> onHold_F12(keyEvent);
            case 127  -> onHold_DELETE(keyEvent);
            case 192  -> onHold_BACK_QUOTE(keyEvent);
            case 222  -> onHold_QUOTE(keyEvent);
        }
    }
    default void onReleaseRouter(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 8  -> onRelease_BACKSPACE(keyEvent);
            case 9  -> onRelease_TAB(keyEvent);
            case 10  -> onRelease_ENTER(keyEvent);
            case 12  -> onRelease_CLEAR(keyEvent);
            case 16  -> onRelease_SHIFT(keyEvent);
            case 17  -> onRelease_CTRL(keyEvent);
            case 18  -> onRelease_ALT(keyEvent);
            case 19  -> onRelease_PAUSE(keyEvent);
            case 20  -> onRelease_CAPS_LOCK(keyEvent);
            case 27  -> onRelease_ESCAPE(keyEvent);
            case 28  -> onRelease_CONVERT(keyEvent);
            case 30  -> onRelease_ACCEPT(keyEvent);
            case 32  -> onRelease_SPACE(keyEvent);
            case 33  -> onRelease_PAGE_UP(keyEvent);
            case 34  -> onRelease_PAGE_DOWN(keyEvent);
            case 35  -> onRelease_END(keyEvent);
            case 36  -> onRelease_HOME(keyEvent);
            case 37  -> onRelease_LEFT(keyEvent);
            case 38  -> onRelease_UP(keyEvent);
            case 39  -> onRelease_RIGHT(keyEvent);
            case 40  -> onRelease_DOWN(keyEvent);
            case 44  -> onRelease_COMMA(keyEvent);
            case 45  -> onRelease_MINUS(keyEvent);
            case 46  -> onRelease_PERIOD(keyEvent);
            case 47  -> onRelease_SLASH(keyEvent);
            case 48  -> onRelease_0(keyEvent);
            case 49  -> onRelease_1(keyEvent);
            case 50  -> onRelease_2(keyEvent);
            case 51  -> onRelease_3(keyEvent);
            case 52  -> onRelease_4(keyEvent);
            case 53  -> onRelease_5(keyEvent);
            case 54  -> onRelease_6(keyEvent);
            case 55  -> onRelease_7(keyEvent);
            case 56  -> onRelease_8(keyEvent);
            case 57  -> onRelease_9(keyEvent);
            case 59  -> onRelease_SEMICOLON(keyEvent);
            case 61  -> onRelease_EQUALS(keyEvent);
            case 65  -> onRelease_A(keyEvent);
            case 66  -> onRelease_B(keyEvent);
            case 67  -> onRelease_C(keyEvent);
            case 68  -> onRelease_D(keyEvent);
            case 69  -> onRelease_E(keyEvent);
            case 70  -> onRelease_F(keyEvent);
            case 71  -> onRelease_G(keyEvent);
            case 72  -> onRelease_H(keyEvent);
            case 73  -> onRelease_I(keyEvent);
            case 74  -> onRelease_J(keyEvent);
            case 75  -> onRelease_K(keyEvent);
            case 76  -> onRelease_L(keyEvent);
            case 77  -> onRelease_M(keyEvent);
            case 78  -> onRelease_N(keyEvent);
            case 79  -> onRelease_O(keyEvent);
            case 80  -> onRelease_P(keyEvent);
            case 81  -> onRelease_Q(keyEvent);
            case 82  -> onRelease_R(keyEvent);
            case 83  -> onRelease_S(keyEvent);
            case 84  -> onRelease_T(keyEvent);
            case 85  -> onRelease_U(keyEvent);
            case 86  -> onRelease_V(keyEvent);
            case 87  -> onRelease_W(keyEvent);
            case 88  -> onRelease_X(keyEvent);
            case 89  -> onRelease_Y(keyEvent);
            case 90  -> onRelease_Z(keyEvent);
            case 91  -> onRelease_OPEN_BRACKET(keyEvent);
            case 92  -> onRelease_BACK_SLASH(keyEvent);
            case 93  -> onRelease_CLOSE_BRACKET(keyEvent);
            case 96  -> onRelease_NUMPAD_0(keyEvent);
            case 97  -> onRelease_NUMPAD_1(keyEvent);
            case 98  -> onRelease_NUMPAD_2(keyEvent);
            case 99  -> onRelease_NUMPAD_3(keyEvent);
            case 100  -> onRelease_NUMPAD_4(keyEvent);
            case 101  -> onRelease_NUMPAD_5(keyEvent);
            case 102  -> onRelease_NUMPAD_6(keyEvent);
            case 103  -> onRelease_NUMPAD_7(keyEvent);
            case 104  -> onRelease_NUMPAD_8(keyEvent);
            case 105  -> onRelease_NUMPAD_9(keyEvent);
            case 106  -> onRelease_NUMPAD_STAR(keyEvent);
            case 107  -> onRelease_NUMPAD_PLUS(keyEvent);
            case 108  -> onRelease_NUMPAD_COMMA(keyEvent);
            case 109  -> onRelease_NUMPAD_DASH(keyEvent);
            case 110  -> onRelease_NUMPAD_PERIOD(keyEvent);
            case 111  -> onRelease_NUMPAD_SLASH(keyEvent);
            case 112  -> onRelease_F1(keyEvent);
            case 113  -> onRelease_F2(keyEvent);
            case 114  -> onRelease_F3(keyEvent);
            case 115  -> onRelease_F4(keyEvent);
            case 116  -> onRelease_F5(keyEvent);
            case 117  -> onRelease_F6(keyEvent);
            case 118  -> onRelease_F7(keyEvent);
            case 119  -> onRelease_F8(keyEvent);
            case 120  -> onRelease_F9(keyEvent);
            case 121  -> onRelease_F10(keyEvent);
            case 122  -> onRelease_F11(keyEvent);
            case 123  -> onRelease_F12(keyEvent);
            case 127  -> onRelease_DELETE(keyEvent);
            case 192  -> onRelease_BACK_QUOTE(keyEvent);
            case 222  -> onRelease_QUOTE(keyEvent);
        }
    }

    default void onPress_BACKSPACE(KeyEvent event) {}
    default void onPress_TAB(KeyEvent event) {}
    default void onPress_ENTER(KeyEvent event) {}
    default void onPress_CLEAR(KeyEvent event) {}
    default void onPress_SHIFT(KeyEvent event) {}
    default void onPress_CTRL(KeyEvent event) {}
    default void onPress_ALT(KeyEvent event) {}
    default void onPress_PAUSE(KeyEvent event) {}
    default void onPress_CAPS_LOCK(KeyEvent event) {}
    default void onPress_ESCAPE(KeyEvent event) {}
    default void onPress_CONVERT(KeyEvent event) {}
    default void onPress_ACCEPT(KeyEvent event) {}
    default void onPress_SPACE(KeyEvent event) {}
    default void onPress_PAGE_UP(KeyEvent event) {}
    default void onPress_PAGE_DOWN(KeyEvent event) {}
    default void onPress_END(KeyEvent event) {}
    default void onPress_HOME(KeyEvent event) {}
    default void onPress_LEFT(KeyEvent event) {}
    default void onPress_UP(KeyEvent event) {}
    default void onPress_RIGHT(KeyEvent event) {}
    default void onPress_DOWN(KeyEvent event) {}
    default void onPress_COMMA(KeyEvent event) {}
    default void onPress_MINUS(KeyEvent event) {}
    default void onPress_PERIOD(KeyEvent event) {}
    default void onPress_SLASH(KeyEvent event) {}
    default void onPress_0(KeyEvent event) {}
    default void onPress_1(KeyEvent event) {}
    default void onPress_2(KeyEvent event) {}
    default void onPress_3(KeyEvent event) {}
    default void onPress_4(KeyEvent event) {}
    default void onPress_5(KeyEvent event) {}
    default void onPress_6(KeyEvent event) {}
    default void onPress_7(KeyEvent event) {}
    default void onPress_8(KeyEvent event) {}
    default void onPress_9(KeyEvent event) {}
    default void onPress_SEMICOLON(KeyEvent event) {}
    default void onPress_EQUALS(KeyEvent event) {}
    default void onPress_A(KeyEvent event) {}
    default void onPress_B(KeyEvent event) {}
    default void onPress_C(KeyEvent event) {}
    default void onPress_D(KeyEvent event) {}
    default void onPress_E(KeyEvent event) {}
    default void onPress_F(KeyEvent event) {}
    default void onPress_G(KeyEvent event) {}
    default void onPress_H(KeyEvent event) {}
    default void onPress_I(KeyEvent event) {}
    default void onPress_J(KeyEvent event) {}
    default void onPress_K(KeyEvent event) {}
    default void onPress_L(KeyEvent event) {}
    default void onPress_M(KeyEvent event) {}
    default void onPress_N(KeyEvent event) {}
    default void onPress_O(KeyEvent event) {}
    default void onPress_P(KeyEvent event) {}
    default void onPress_Q(KeyEvent event) {}
    default void onPress_R(KeyEvent event) {}
    default void onPress_S(KeyEvent event) {}
    default void onPress_T(KeyEvent event) {}
    default void onPress_U(KeyEvent event) {}
    default void onPress_V(KeyEvent event) {}
    default void onPress_W(KeyEvent event) {}
    default void onPress_X(KeyEvent event) {}
    default void onPress_Y(KeyEvent event) {}
    default void onPress_Z(KeyEvent event) {}
    default void onPress_OPEN_BRACKET(KeyEvent event) {}
    default void onPress_BACK_SLASH(KeyEvent event) {}
    default void onPress_CLOSE_BRACKET(KeyEvent event) {}
    default void onPress_NUMPAD_0(KeyEvent event) {}
    default void onPress_NUMPAD_1(KeyEvent event) {}
    default void onPress_NUMPAD_2(KeyEvent event) {}
    default void onPress_NUMPAD_3(KeyEvent event) {}
    default void onPress_NUMPAD_4(KeyEvent event) {}
    default void onPress_NUMPAD_5(KeyEvent event) {}
    default void onPress_NUMPAD_6(KeyEvent event) {}
    default void onPress_NUMPAD_7(KeyEvent event) {}
    default void onPress_NUMPAD_8(KeyEvent event) {}
    default void onPress_NUMPAD_9(KeyEvent event) {}
    default void onPress_NUMPAD_STAR(KeyEvent event) {}
    default void onPress_NUMPAD_PLUS(KeyEvent event) {}
    default void onPress_NUMPAD_COMMA(KeyEvent event) {}
    default void onPress_NUMPAD_DASH(KeyEvent event) {}
    default void onPress_NUMPAD_PERIOD(KeyEvent event) {}
    default void onPress_NUMPAD_SLASH(KeyEvent event) {}
    default void onPress_F1(KeyEvent event) {}
    default void onPress_F2(KeyEvent event) {}
    default void onPress_F3(KeyEvent event) {}
    default void onPress_F4(KeyEvent event) {}
    default void onPress_F5(KeyEvent event) {}
    default void onPress_F6(KeyEvent event) {}
    default void onPress_F7(KeyEvent event) {}
    default void onPress_F8(KeyEvent event) {}
    default void onPress_F9(KeyEvent event) {}
    default void onPress_F10(KeyEvent event) {}
    default void onPress_F11(KeyEvent event) {}
    default void onPress_F12(KeyEvent event) {}
    default void onPress_DELETE(KeyEvent event) {}
    default void onPress_BACK_QUOTE(KeyEvent event) {}
    default void onPress_QUOTE(KeyEvent event) {}

    default void onHold_BACKSPACE(KeyEvent event) {}
    default void onHold_TAB(KeyEvent event) {}
    default void onHold_ENTER(KeyEvent event) {}
    default void onHold_CLEAR(KeyEvent event) {}
    default void onHold_SHIFT(KeyEvent event) {}
    default void onHold_CTRL(KeyEvent event) {}
    default void onHold_ALT(KeyEvent event) {}
    default void onHold_PAUSE(KeyEvent event) {}
    default void onHold_CAPS_LOCK(KeyEvent event) {}
    default void onHold_ESCAPE(KeyEvent event) {}
    default void onHold_CONVERT(KeyEvent event) {}
    default void onHold_ACCEPT(KeyEvent event) {}
    default void onHold_SPACE(KeyEvent event) {}
    default void onHold_PAGE_UP(KeyEvent event) {}
    default void onHold_PAGE_DOWN(KeyEvent event) {}
    default void onHold_END(KeyEvent event) {}
    default void onHold_HOME(KeyEvent event) {}
    default void onHold_LEFT(KeyEvent event) {}
    default void onHold_UP(KeyEvent event) {}
    default void onHold_RIGHT(KeyEvent event) {}
    default void onHold_DOWN(KeyEvent event) {}
    default void onHold_COMMA(KeyEvent event) {}
    default void onHold_MINUS(KeyEvent event) {}
    default void onHold_PERIOD(KeyEvent event) {}
    default void onHold_SLASH(KeyEvent event) {}
    default void onHold_0(KeyEvent event) {}
    default void onHold_1(KeyEvent event) {}
    default void onHold_2(KeyEvent event) {}
    default void onHold_3(KeyEvent event) {}
    default void onHold_4(KeyEvent event) {}
    default void onHold_5(KeyEvent event) {}
    default void onHold_6(KeyEvent event) {}
    default void onHold_7(KeyEvent event) {}
    default void onHold_8(KeyEvent event) {}
    default void onHold_9(KeyEvent event) {}
    default void onHold_SEMICOLON(KeyEvent event) {}
    default void onHold_EQUALS(KeyEvent event) {}
    default void onHold_A(KeyEvent event) {}
    default void onHold_B(KeyEvent event) {}
    default void onHold_C(KeyEvent event) {}
    default void onHold_D(KeyEvent event) {}
    default void onHold_E(KeyEvent event) {}
    default void onHold_F(KeyEvent event) {}
    default void onHold_G(KeyEvent event) {}
    default void onHold_H(KeyEvent event) {}
    default void onHold_I(KeyEvent event) {}
    default void onHold_J(KeyEvent event) {}
    default void onHold_K(KeyEvent event) {}
    default void onHold_L(KeyEvent event) {}
    default void onHold_M(KeyEvent event) {}
    default void onHold_N(KeyEvent event) {}
    default void onHold_O(KeyEvent event) {}
    default void onHold_P(KeyEvent event) {}
    default void onHold_Q(KeyEvent event) {}
    default void onHold_R(KeyEvent event) {}
    default void onHold_S(KeyEvent event) {}
    default void onHold_T(KeyEvent event) {}
    default void onHold_U(KeyEvent event) {}
    default void onHold_V(KeyEvent event) {}
    default void onHold_W(KeyEvent event) {}
    default void onHold_X(KeyEvent event) {}
    default void onHold_Y(KeyEvent event) {}
    default void onHold_Z(KeyEvent event) {}
    default void onHold_OPEN_BRACKET(KeyEvent event) {}
    default void onHold_BACK_SLASH(KeyEvent event) {}
    default void onHold_CLOSE_BRACKET(KeyEvent event) {}
    default void onHold_NUMPAD_0(KeyEvent event) {}
    default void onHold_NUMPAD_1(KeyEvent event) {}
    default void onHold_NUMPAD_2(KeyEvent event) {}
    default void onHold_NUMPAD_3(KeyEvent event) {}
    default void onHold_NUMPAD_4(KeyEvent event) {}
    default void onHold_NUMPAD_5(KeyEvent event) {}
    default void onHold_NUMPAD_6(KeyEvent event) {}
    default void onHold_NUMPAD_7(KeyEvent event) {}
    default void onHold_NUMPAD_8(KeyEvent event) {}
    default void onHold_NUMPAD_9(KeyEvent event) {}
    default void onHold_NUMPAD_STAR(KeyEvent event) {}
    default void onHold_NUMPAD_PLUS(KeyEvent event) {}
    default void onHold_NUMPAD_COMMA(KeyEvent event) {}
    default void onHold_NUMPAD_DASH(KeyEvent event) {}
    default void onHold_NUMPAD_PERIOD(KeyEvent event) {}
    default void onHold_NUMPAD_SLASH(KeyEvent event) {}
    default void onHold_F1(KeyEvent event) {}
    default void onHold_F2(KeyEvent event) {}
    default void onHold_F3(KeyEvent event) {}
    default void onHold_F4(KeyEvent event) {}
    default void onHold_F5(KeyEvent event) {}
    default void onHold_F6(KeyEvent event) {}
    default void onHold_F7(KeyEvent event) {}
    default void onHold_F8(KeyEvent event) {}
    default void onHold_F9(KeyEvent event) {}
    default void onHold_F10(KeyEvent event) {}
    default void onHold_F11(KeyEvent event) {}
    default void onHold_F12(KeyEvent event) {}
    default void onHold_DELETE(KeyEvent event) {}
    default void onHold_BACK_QUOTE(KeyEvent event) {}
    default void onHold_QUOTE(KeyEvent event) {}

    default void onRelease_BACKSPACE(KeyEvent event) {}
    default void onRelease_TAB(KeyEvent event) {}
    default void onRelease_ENTER(KeyEvent event) {}
    default void onRelease_CLEAR(KeyEvent event) {}
    default void onRelease_SHIFT(KeyEvent event) {}
    default void onRelease_CTRL(KeyEvent event) {}
    default void onRelease_ALT(KeyEvent event) {}
    default void onRelease_PAUSE(KeyEvent event) {}
    default void onRelease_CAPS_LOCK(KeyEvent event) {}
    default void onRelease_ESCAPE(KeyEvent event) {}
    default void onRelease_CONVERT(KeyEvent event) {}
    default void onRelease_ACCEPT(KeyEvent event) {}
    default void onRelease_SPACE(KeyEvent event) {}
    default void onRelease_PAGE_UP(KeyEvent event) {}
    default void onRelease_PAGE_DOWN(KeyEvent event) {}
    default void onRelease_END(KeyEvent event) {}
    default void onRelease_HOME(KeyEvent event) {}
    default void onRelease_LEFT(KeyEvent event) {}
    default void onRelease_UP(KeyEvent event) {}
    default void onRelease_RIGHT(KeyEvent event) {}
    default void onRelease_DOWN(KeyEvent event) {}
    default void onRelease_COMMA(KeyEvent event) {}
    default void onRelease_MINUS(KeyEvent event) {}
    default void onRelease_PERIOD(KeyEvent event) {}
    default void onRelease_SLASH(KeyEvent event) {}
    default void onRelease_0(KeyEvent event) {}
    default void onRelease_1(KeyEvent event) {}
    default void onRelease_2(KeyEvent event) {}
    default void onRelease_3(KeyEvent event) {}
    default void onRelease_4(KeyEvent event) {}
    default void onRelease_5(KeyEvent event) {}
    default void onRelease_6(KeyEvent event) {}
    default void onRelease_7(KeyEvent event) {}
    default void onRelease_8(KeyEvent event) {}
    default void onRelease_9(KeyEvent event) {}
    default void onRelease_SEMICOLON(KeyEvent event) {}
    default void onRelease_EQUALS(KeyEvent event) {}
    default void onRelease_A(KeyEvent event) {}
    default void onRelease_B(KeyEvent event) {}
    default void onRelease_C(KeyEvent event) {}
    default void onRelease_D(KeyEvent event) {}
    default void onRelease_E(KeyEvent event) {}
    default void onRelease_F(KeyEvent event) {}
    default void onRelease_G(KeyEvent event) {}
    default void onRelease_H(KeyEvent event) {}
    default void onRelease_I(KeyEvent event) {}
    default void onRelease_J(KeyEvent event) {}
    default void onRelease_K(KeyEvent event) {}
    default void onRelease_L(KeyEvent event) {}
    default void onRelease_M(KeyEvent event) {}
    default void onRelease_N(KeyEvent event) {}
    default void onRelease_O(KeyEvent event) {}
    default void onRelease_P(KeyEvent event) {}
    default void onRelease_Q(KeyEvent event) {}
    default void onRelease_R(KeyEvent event) {}
    default void onRelease_S(KeyEvent event) {}
    default void onRelease_T(KeyEvent event) {}
    default void onRelease_U(KeyEvent event) {}
    default void onRelease_V(KeyEvent event) {}
    default void onRelease_W(KeyEvent event) {}
    default void onRelease_X(KeyEvent event) {}
    default void onRelease_Y(KeyEvent event) {}
    default void onRelease_Z(KeyEvent event) {}
    default void onRelease_OPEN_BRACKET(KeyEvent event) {}
    default void onRelease_BACK_SLASH(KeyEvent event) {}
    default void onRelease_CLOSE_BRACKET(KeyEvent event) {}
    default void onRelease_NUMPAD_0(KeyEvent event) {}
    default void onRelease_NUMPAD_1(KeyEvent event) {}
    default void onRelease_NUMPAD_2(KeyEvent event) {}
    default void onRelease_NUMPAD_3(KeyEvent event) {}
    default void onRelease_NUMPAD_4(KeyEvent event) {}
    default void onRelease_NUMPAD_5(KeyEvent event) {}
    default void onRelease_NUMPAD_6(KeyEvent event) {}
    default void onRelease_NUMPAD_7(KeyEvent event) {}
    default void onRelease_NUMPAD_8(KeyEvent event) {}
    default void onRelease_NUMPAD_9(KeyEvent event) {}
    default void onRelease_NUMPAD_STAR(KeyEvent event) {}
    default void onRelease_NUMPAD_PLUS(KeyEvent event) {}
    default void onRelease_NUMPAD_COMMA(KeyEvent event) {}
    default void onRelease_NUMPAD_DASH(KeyEvent event) {}
    default void onRelease_NUMPAD_PERIOD(KeyEvent event) {}
    default void onRelease_NUMPAD_SLASH(KeyEvent event) {}
    default void onRelease_F1(KeyEvent event) {}
    default void onRelease_F2(KeyEvent event) {}
    default void onRelease_F3(KeyEvent event) {}
    default void onRelease_F4(KeyEvent event) {}
    default void onRelease_F5(KeyEvent event) {}
    default void onRelease_F6(KeyEvent event) {}
    default void onRelease_F7(KeyEvent event) {}
    default void onRelease_F8(KeyEvent event) {}
    default void onRelease_F9(KeyEvent event) {}
    default void onRelease_F10(KeyEvent event) {}
    default void onRelease_F11(KeyEvent event) {}
    default void onRelease_F12(KeyEvent event) {}
    default void onRelease_DELETE(KeyEvent event) {}
    default void onRelease_BACK_QUOTE(KeyEvent event) {}
    default void onRelease_QUOTE(KeyEvent event) {}
}
