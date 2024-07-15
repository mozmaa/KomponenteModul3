import { Button } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import TestAxios from "../../apis/TestAxios"
import FormCheckInput from "react-bootstrap/esm/FormCheckInput"
import { useState } from "react"

export const KomponentaRow = (props) => {

    console.log(props)
    let imgString = ['AMD Ryzen 9 3950X.jpg', 'Gigabyte B450 Aorus M.jpg' , 'Gigabyte GeForce RTX 2080 Super OC.png',
                    'Kingston DDR4 HyperX Predator.jpeg' , 'Samsung 970 EVO Plus.png' , 'Samsung C24FG73.jpg']
    
    const imgSrc = (slika) => {
        for (let i = 0 ; i < imgString.length ; i++){
            if(slika === imgString[i])
            return imgString[i]  
        }    
    }
    
    // console.log(imgSrc(props.komponenta.slika))
    const navigate = useNavigate()
    // const isZaduzeniUser = (props.loginInfo?.name)?.toUpperCase() === (props.komponenta.imeKorisnika).toUpperCase()

    const goToEdit = (komponenta) =>{
        props.editCallback(komponenta)
        navigate('/komponenta/edit')
    }

    const deletePretplata = (id) => {
        TestAxios.delete('/komponente/' + id)
            .then(res => {
                alert ('Uspesno brisanje')
                props.deleteCallback((komponente)=>komponente.filter(komponente => komponente.id !== id))
                if(props.komponente.length === 1){
                    props.getKomponentaCallback(props.pageNo-1)
                }
            }).catch(error => {
                alert('Doslo je do greske prilikom brisanja')
            })
    }

    
    const kupi = (id) => {
        
        const datum = new Date().toISOString().substring(0,16)
        const conf = {
                'datumIVremeKupovine': datum,
                'komponentaId': id,
        }

        console.log(conf)
        
        TestAxios.post('/racuni' , conf)
            .then(res => {
                alert('Uspesna kupovina')
                props.getKomponentaCallback(props.pageNo)
            }).catch(error => {
                console.log(error)
                alert('Doslo je do greske')
            })
    }

    const edit = (id, komponenta) => {
        komponenta = {
            ...komponenta,
            dostupnost: !komponenta.dostupnost
        }
        TestAxios.put(`/komponente/${id}` , komponenta)
            .then(res => {
                alert('Uspesna izmena')
                props.getKomponentaCallback(props.pageNo)
            }).catch (error => {
                console.log(error)
                alert('Doslo je do greske')
            })
    }
    
    return (
        <tr key={props.komponenta.id}>
            <td><img style={{width:50, height:50}} src={window.location.origin + `/images/${imgSrc(props.komponenta.slika)}`} alt="img not Found"></img></td>
            <td>{props.komponenta.proizvodjacNaziv}</td>
            <td>{props.komponenta.model}</td>
            <td>{props.komponenta.datumDostupnosti}</td>
            <td>{props.komponenta.dostupnost && props.komponenta.cena}</td>
            <td><FormCheckInput name="dostupnost" checked={props.komponenta.dostupnost} onChange={(e) => {edit(props.komponenta.id, props.komponenta)}}></FormCheckInput></td>
            {props.loginInfo?.isAdmin  &&
                 <td><Button disabled={props.komponenta.dostupnost.toString() === 'false'}  onClick={() => kupi(props.komponenta.id)} >Kupi</Button></td>
                 }
            {props.loginInfo?.isAdmin && <td><Button variant="warning" onClick={() => goToEdit(props.komponenta)} >Edit</Button></td>}
            {props.loginInfo?.isAdmin && <td><Button variant="danger" onClick={() => deletePretplata(props.komponenta.id)}>Delete</Button></td>}
            {/* {props.loginInfo?.isAdmin && <td><Button  onClick={() => edit(props.komponenta.id)}>Izmeni dostupnost</Button></td>} */}
        </tr>
    )
}