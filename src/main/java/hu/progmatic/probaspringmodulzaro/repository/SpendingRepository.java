package hu.progmatic.probaspringmodulzaro.repository;

import hu.progmatic.probaspringmodulzaro.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Integer> {
}
