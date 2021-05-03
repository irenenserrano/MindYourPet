package com.example.mindyourpet

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindyourpet.database.Pet

class AllPetsListFragment : Fragment(), OnPetItemClickListener {

    companion object {
      //  fun newInstance() = AllPetsListFragment()
        val pets = listOf<Pet>(Pet(name = "Benny", speciesId = 1), Pet(name ="Bella", speciesId = 1), Pet(name ="Charlie", speciesId = 1))
    }

    private lateinit var viewModel: AllPetsListViewModel
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // https://stackoverflow.com/a/33388481/631051
        val root = inflater.inflate(R.layout.all_pets_list_fragment,null)

//        // Create the adapter and associate it with with the RecyclerView.
//        val petList = root.findViewById<RecyclerView>(R.id.pet_list)
//        petList.adapter = PetAdapter(this)
//
//        val application = requireNotNull(this.activity).application
//        layoutManager = LinearLayoutManager(application)
//        petList.layoutManager = layoutManager
//
//        //Get a reference to the ViewModel associated with this Fragment
//        val allPetsListViewModel = ViewModelProvider(this, AllPetsListViewModelFactory(pets, application)).get(AllPetsListViewModel::class.java)
//
//        /*
//        // Add an observer to the the list of pets
//        allPetsListViewModel.listOfPets.observe(viewLifecycleOwner, Observer{
//            it?.let {
//                petList?.adapter?.data = it
//            }
//        })
//*/
//
//        val fab: View = root.findViewById(R.id.pet_FAB)
//        fab.setOnClickListener {
//            Toast.makeText(it.context,"Item Clicked", Toast.LENGTH_LONG).show()
////            viewModel.navigateToAddPet.observe(viewLifecycleOwner, Observer<Boolean> { navigate ->
////                if(navigate){
////                    val navController = findNavController()
////                    navController.navigate(R.id.action_homeFragment_to_gdgListFragment)
////                    viewModel.onNavigatedToAddPet()
////                }
////
////            })
//        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllPetsListViewModel::class.java)
    }

    override fun onPetItemClicked(item: Pet, position: Int) {
        Toast.makeText(this.context, item.name +"'s profile was clicked", Toast.LENGTH_LONG ).show()
        val navController = findNavController()
        navController.navigate(AllPetsListFragmentDirections.actionAllPetsListFragmentToRemindersListFragment(item.petId))
    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_top, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var id = item.itemId
//        if (id == R.id.delete_button) {
//            this?.let{
//                Toast.makeText(it.context, "item clicked", Toast.LENGTH_LONG).show()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}