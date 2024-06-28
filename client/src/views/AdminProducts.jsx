import React from 'react'
import { Nav, NavItem, NavLink } from 'reactstrap'

const AdminProducts = () => {
  return (
    <div className='adminLayout'>
    <div className='adminNav'>
      <h5>ECOMADMIN</h5>
      <Nav
      navbar
        card
        tabs
        vertical
        dark
        
      >
        <NavItem>
          <NavLink
            active
            href="#"
          >
            Home
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#">
            Products
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#">
            Products
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            disabled
            href="#"
          >
            Disabled Link
          </NavLink>
        </NavItem>
      </Nav>
    </div>
    <div>
      <p>testing box</p>
    </div>
    </div>
  )
}

export default AdminProducts