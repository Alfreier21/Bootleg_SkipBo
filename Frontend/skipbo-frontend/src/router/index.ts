import {createRouter, createWebHistory} from 'vue-router'
// import MyTestComponent from '@/components/MyTestComponent.vue'
import GameView from '@/components/GameView.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('@/components/LandingPage.vue'),
        },
        {
            path: '/game/:gameId',
            name: 'game',
            component: GameView,
        }

    ]
})

export default router