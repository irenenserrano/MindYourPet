package com.example.mindyourpet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindyourpet.database.DOG_ID
import com.example.mindyourpet.database.Pet

/**
 * Fragment listing all pets and enabling a user to add a new pet.
 * To add a new pet, the user clicks a Floating Action Button.
 */
class AllPetsListFragment : Fragment(), OnPetItemClickListener {

    companion object {
       private val DEFAULT_PETS = listOf(
            Pet(name = "Benny", speciesId = DOG_ID),
            Pet(name = "Bella", speciesId = DOG_ID),
            Pet(name = "Charlie", speciesId = DOG_ID)
        )
    }

    private lateinit var allPetsListViewModel: AllPetsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // https://stackoverflow.com/a/33388481/631051
        val root = inflater.inflate(R.layout.all_pets_list_fragment, container, false)

        // The layout manager must be set before the adapter.
        // https://stackoverflow.com/a/47973416/631051
        val petList = root.findViewById<RecyclerView>(R.id.pet_list)
        petList.layoutManager = LinearLayoutManager(requireNotNull(activity))

        val petAdapter = PetAdapter(this)
        petList.adapter = petAdapter

        //Get a reference to the ViewModel associated with this Fragment
        allPetsListViewModel =
            ViewModelProvider(this, AllPetsListViewModelFactory(DEFAULT_PETS)).get(
                AllPetsListViewModel::class.java
            )
        // Add an observer to the the list of pets
        allPetsListViewModel.listOfPets.observe(viewLifecycleOwner, Observer {
            it?.let {
                petAdapter.data = it
            }
        })

        val fab: View = root.findViewById(R.id.pet_FAB)
        fab.setOnClickListener {
            Toast.makeText(it.context, "Item Clicked", Toast.LENGTH_LONG).show()
            //TODO: add navigation to AddPetFragment once fragment is completed
        }
        return root
    }

    override fun onPetItemClicked(item: Pet, position: Int) {
        val navController = findNavController()
        navController.navigate(
            AllPetsListFragmentDirections.actionAllPetsListFragmentToRemindersListFragment(
                item.petId
            )
        )
    }
}