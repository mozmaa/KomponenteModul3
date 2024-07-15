import { useEffect, useState } from "react"
import { Form, FormSelect } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Row } from "react-bootstrap"
import TestAxios from "../../apis/TestAxios"
import { useNavigate } from "react-router-dom"
import FormCheckInput from "react-bootstrap/esm/FormCheckInput"

export const EditKomponenta = (props) => {

    const [editKomponenta, setEditKomponenta] = useState(props.selectedKomponenta)
    const [proizvodjaci, setProizvodjaci] = useState([])
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
        //      setEditPretplata({ ...editPretplata, [e.target.name]: datumPocetka })
        //      console.log(datumPocetka)
        //      return;
        // }
        setEditKomponenta({ ...editKomponenta, [e.target.name]: e.target.value })
    }

    const edit = (id) => {
        TestAxios.put(`/komponente/${id}` , editKomponenta)
            .then(res => {
                alert('Uspesna izmena')
                navigate('/komponente')
            }).catch (error => {
                alert('Doslo je do greske')
            })
    }

    return (
        <Row className="justify-content-center">
        <Col md={8}>
            <h1>Edit</h1>
            <Form.Group>
                <Form.Label>Proizvodjac</Form.Label>
                <FormSelect name="proizvodjacId" value={editKomponenta.proizvodjacId} onChange={(e) => handleChange(e)}>
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
                <Form.Control type='text' name='model' value={editKomponenta.model} onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Datum dostupnosti</Form.Label>
                <Form.Control type='date' name='datumDostupnosti' value={editKomponenta.datumDostupnosti} onChange={(e) => handleChange(e)}></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Cena</Form.Label>
                <Form.Control type='number' name='cena' value={editKomponenta.cena} onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Form.Group>
                <Form.Label>Dostupna</Form.Label>
                <FormCheckInput name="dostupnost" style={{marginLeft: 10, marginTop:8}} checked={editKomponenta.dostupnost} onChange={(e) => setEditKomponenta({ ...editKomponenta, [e.target.name]: e.target.checked })}></FormCheckInput>
            </Form.Group>
            <Form.Group>
                <Form.Label>Slika</Form.Label>
                <Form.Control type='text' name='slika' value={editKomponenta.slika} onChange={(e) => handleChange(e)} ></Form.Control>
            </Form.Group>
            <Button style={{ marginTop: 10, marginBottom: 10 }} onClick={() => edit(editKomponenta.id)}>Dodaj</Button>
        </Col>
    </Row>
    )
}