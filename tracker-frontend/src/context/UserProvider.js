import React from 'react'
import { useAuth } from './AuthProvider'

const UserContext = React.createContext()

function UserProvider() {
    return <UserContext.Provider value={{/*useAuth().userData.user, useAuth().displayData*/}} />
} 

export default UserProvider;