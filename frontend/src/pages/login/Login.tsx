export default function Login(){

    
    return(
        <div>
            <h1>Login</h1>
            <label htmlFor="username">Username</label>
            <input type="text" id="username" name="username" />
            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password" />
            <button type="submit">Login</button>
        </div>
    )
}