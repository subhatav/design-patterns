package practice.structural.proxy;

import lombok.NonNull;

@FunctionalInterface
public interface CompanyRoom {

  void use(@NonNull final Developer developer);
}
