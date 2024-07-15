import { Form, FormSelect } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Row } from "react-bootstrap"

export const Search = (props) => {

    const handleChange = (e) => {
        props.searchParamsCallback({...props.searchParams, [e.target.name]: e.target.value})
    }

    return (
    <Row className="justify-content-center">
    <Col md={8}>
        <Form.Group>
            <Form.Label>Datum od</Form.Label>
            <Form.Control type="date" name='datumOd' onChange={(e) => handleChange(e)}></Form.Control>
        </Form.Group>
        <Form.Group>
            <Form.Label>Datum do</Form.Label>
            <Form.Control type="date" name='datumDo'   onChange={(e) => handleChange(e)}></Form.Control>
        </Form.Group>
        <Form.Group>
            <Form.Label>Proizvodjac</Form.Label>
            <FormSelect name="proizvodjacId" onChange={(e) => handleChange(e)}>
                <option value=''>--</option>
                {props.proizvodjaci.map((proizvodjac, index)=> {
                    return(
                        <option key={index} value={proizvodjac.id}>{proizvodjac.naziv}</option>
                    )
                })
            }   
            </FormSelect>
        </Form.Group>
        <Button style={{ marginTop: 10, marginBottom: 10 }} onClick={() => props.getKomponenteCallback(0)}>Search</Button>
    </Col>
</Row>)
}