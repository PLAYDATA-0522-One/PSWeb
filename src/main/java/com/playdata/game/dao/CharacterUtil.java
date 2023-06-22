package com.playdata.game.dao;

public class CharacterUtil {
        public static String getImageUrl(String job) {
            if (job.contains("전사")) {
                return "/img/warrior.png";
            } else if (job.contains("마법사")) {
                return "/img/magician.png";
            } else if (job.contains("도적")) {
                return "/img/Thief.png";
            }
            // 기본 이미지 URL을 반환하는 경우 등 추가적인 처리
            return "/img/default.png";
        }
}
