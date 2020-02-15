package br.com.gsafj.util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DataStructureConverter {

  private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  public static <T> T parseObject(final Object origin,
                                   final Class<T> destination) {
    return mapper.map(origin, destination);
  }

  public static <O, T> List<T> parseAll(final List<O> originList,
                                      final Class<T> destination) {
    final List<T> result = new ArrayList<>();
    for (final O origin : originList) {
      result.add(mapper.map(origin, destination));
    }
    return result;
  }
}
