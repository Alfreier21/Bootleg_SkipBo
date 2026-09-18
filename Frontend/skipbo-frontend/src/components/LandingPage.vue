<script setup lang='ts'>
import {ref} from 'vue'
import router from "@/router/index.ts";
const gameRoom = ref('')
const playerName = ref('')

    async function createGame(){
        const response = await fetch(import.meta.env.VITE_API_JoinGame, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                gameName: gameRoom.value
            })
        })
        const res: {"gameRoom": string} = await response.json()
        router.push("/game/"+res.gameRoom)
    }
</script>

<template>
    <body>
        <h2>Welcome to this Sikpbo Website!</h2>
    <p>Skipbo is a popular and well known card game. Player now for free against your friends! ^~^</p>

    <div>
        <span>Enter game room:</span>
        <br>
        <input v-model="gameRoom" />
        <br>
        <span>Enter player name:</span>
        <br>
        <input v-model="playerName" />
        <br>
        <button @click="createGame" > start game </button>
    </div>
    </body>
</template>