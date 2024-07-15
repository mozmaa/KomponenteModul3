import { useEffect, useState } from "react"
import TestAxios from "../../apis/TestAxios"
import { Col, FormCheck, FormLabel, Stack , Button} from "react-bootstrap"
import { Row } from "react-bootstrap"
import FormCheckInput from "react-bootstrap/esm/FormCheckInput"
import { Search } from "./Search"
import { Table } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import { KomponentaRow } from "./KomponentaRow"


export const Komponente = (props) => {

    const[komponente, setKomponente] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [pageCount, setPageCount] = useState(0)
    const [checked, setChecked] = useState(false)
    const [searchParams, setSearchParams] = useState({})
    const[proizvodjaci, setProizvodjaci] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        getKomponente(0)
        getProizvodjaci()
    }, [])

    const getKomponente = (newPageNo) => {

        const conf = {
            params: {
                ...searchParams,
                pageNo: newPageNo
            }
        }

        // console.log(conf)

        TestAxios.get('/komponente', conf)
            .then(res => {
                console.log(res)
                setKomponente(res.data)
                setPageCount(Number(res.headers['total-pages']))
                setPageNo(newPageNo)
                
            }).catch(error => {
                console.log(error)
                alert('Doslo je do greske')
            })
    }


    const getProizvodjaci = () => {
        TestAxios.get('/proizvodjaci')
            .then(res => {
                setProizvodjaci(res.data)
            }).catch(error => {
                alert('Doslo je do greske!')
            })
    }

    const RenderKomponente = () => {
        return komponente.map((komponenta,index) => {
            return (
            <KomponentaRow key={index} komponenta={komponenta} editCallback={props.callback} 
                        loginInfo={props.loginInfo} komponente={komponente} deleteCallback={(komponente) => setKomponente(komponente)}
                        pageNo = {pageNo} getKomponentaCallback={(pageNo) => {getKomponente(pageNo)}} >
            </KomponentaRow>
            )
        })
    }

    const goToAdd = () => {
        navigate('/komponente/dodavanje')
    }

    

    return(
        <Col>
            <Row><h1>Komponente</h1></Row>
            <FormCheck>
                <FormCheckInput name="pretraga" onChange={(e) => setChecked(e.target.checked)}></FormCheckInput>
                <FormLabel htmlFor="pretraga">Prikazi pretragu</FormLabel>
            </FormCheck>
            {checked && <Search searchParamsCallback={(searchParams) => setSearchParams(searchParams)} 
                getKomponenteCallback={(firstPage) => getKomponente(firstPage)} searchParams={searchParams} proizvodjaci={proizvodjaci}/>}
            <br></br>
            <Row><Col>
                <Table striped bordered hover  id="linije=table">
                    <thead>
                        <tr>
                            <th>Slika</th>
                            <th>Proizvodjac</th>
                            <th>Model</th>
                            <th>DatumDostupnosti</th>
                            <th>Cena</th>
                            <th>Dostupna</th>
                            {props.loginInfo?.isAdmin&& <th></th> }
                            {props.loginInfo?.isAdmin  && <th></th> }
                            {props.loginInfo?.isAdmin  && <th></th> }
                        </tr>
                    </thead>
                    <tbody>
                        {RenderKomponente()}
                    </tbody>
                </Table>
            </Col></Row>
            <Stack direction="horizontal" gap={3}>
                {props.loginInfo?.isAdmin ? <Button className="button button-navy" onClick={() => goToAdd()}>Add</Button> : <></>}
                <Button className="ms-auto" disabled={pageNo === 0} onClick={() => getKomponente(pageNo - 1)}>Prev</Button>
                {komponente.length === 0 ? pageNo : pageNo + 1}/{pageCount}
                <Button disabled={pageNo === pageCount - 1} onClick={() => getKomponente(pageNo + 1)}>Next</Button>
            </Stack>
        </Col>
    )
}