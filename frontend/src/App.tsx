import Header from './components/Header'
import Footer from './components/Footer'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Dashboard from './pages/dashboard/Dashboard'
import Login from './pages/login/Login';

function App() {
  return(
    <BrowserRouter>
      <Header/>
      <Routes> 
        <Route path='/' element={<Dashboard/>}/>
        <Route path='/login' element={<Login/>}/>
      </Routes>
      <Footer/>   
    </BrowserRouter>
  );
}

export default App
