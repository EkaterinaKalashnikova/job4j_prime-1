package ru.job4j.oop.ballstory;

public class BallStory {
    public static void main(String[] args) {
        System.out.println("Испекли бабка с дедом колобок и покатился он по дороге. ");
        Ball ball = new Ball();
        Hare hare = new Hare();
        System.out.println("Навстречу ему заяц, колобок говорит: не ешь меня,"
                 + " я не похож на морковку, заяц оглядел его: верно не похож, и...");
        hare.tryEat(ball);
        System.out.println(" только его и видели");
        System.out.println("Вдруг навстречу ему волк, колобок говорит: не ешь меня,"
                + " я горький сильно, волк сморщился и задумался, и... ");
        Wolf wolf = new Wolf();
        wolf.tryEat(ball);
        System.out.println(" и быстро-быстро покатился по дороге, пока волк думал. ");
        System.out.println("А навстречу ему лиса-красавица, колобок ей говорит:"
               + " несвежий я продукт, а она в ответ: только попробую, и ");
        Fox fox = new Fox();
        fox.tryEat(ball);
        System.out.println("Тут и сказочке конец!");
    }
}
