import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import TestAxios from "../../apis/TestAxios"
import { FormSelect, Row } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import FormCheckInput from "react-bootstrap/esm/FormCheckInput"

export const AddKomponenta = () => {

    const [proizvodjaci, setProizvodjaci] = useState([])
    const [novaKomponenta, setNovaKomponenta] = useState({dostupnost: ''})
    const navigate = useNavigate()

    useEffect(() => {
        getProizvodjaci()
    }, [])

    const getProizvodjaci = () => {
        TestAxios.get('/proizvodjaci')
            .then(res => {
                setProizvodjaci(res.data)
            }).catch(error => {
                alert('Doslo je do greske!')
            })
    }

    const handleChange = (e) => {
        // if(e.target.name === "datumPocetka"){
        //     let date = new Date()
        //      let datumPocetka = e.target.value + ' '  + date.getHours() + ':' + date.getMinutes()
        //      setNovaPretplata({ ...novaPretplata, [e.target.name]: datumPocetka })
        //      console.log(datumPocetka)
        //      return;
        // }
        setNovaKomponenta({ ...novaKomponenta, [e.target.name]: e.target.value })
    }

    const addKomponentu = () => {
        TestAxios.post('/komponente', novaKomponenta)
            .then(res => {
                alert('Uspesno dodavanje')
                navigate('/komponente')
            }).catch(error => {
                alert('Doslo je do greske')
            })
    }

    return(
        <Row className="justify-content-center">
        <Col md={8}>
            <h1>Dodavanje</h1>
            <Form.Group>
                <Form.Label>Proizvodjac</Form.Label>
                <FormSelect name="proizvodjacId" onChange={(e) => handleChange(e)}>
                    <option value=''>--</option>
                    {proizvodjaci.map((proizvodjac, index) => {
                        return (
                            <option key={index} value={proizvodjac.id}>{proizvodjac.naziv}</option>
                        )
                    })
                    }
                </FormSelect>
            </Form.Group>
            <Form.Group>
                <Form.Label>Model</Form.Label>
                <Form.Control type='text' name='model' onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Datum dostupnosti</Form.Label>
                <Form.Control type='date' name='datumDostupnosti'  onChange={(e) => handleChange(e)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Cena</Form.Label>
                <Form.Control type='number' name='cena' onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Dostupna</Form.Label>
                <FormCheckInput name="dostupnost" style={{marginLeft: 10, marginTop:8}} value={false} onChange={(e) => setNovaKomponenta({ ...novaKomponenta, [e.target.name]: e.target.checked })}></FormCheckInput>
            </Form.Group>
            <Form.Group>
                <Form.Label>Slika</Form.Label>
                <Form.Control type='text' name='slika' onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Button style={{ marginTop: 10, marginBottom: 10 }} onClick={addKomponentu}>Dodaj</Button>
        </Col>
    </Row>
    )
}