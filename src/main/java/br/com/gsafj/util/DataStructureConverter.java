package br.com.gsafj.util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DataStructureConverter {

  public static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  private static <T> T parseObject(final Object origin,
                                   final Class<T> destination) {
    return mapper.map(origin, destination);
  }

  private static <T> List<T> parseAll(final List<Object> originList,
                                      final Class<T> destination) {
    final List<T> result = new ArrayList<>();
    for (final Object origin : originList) {
      result.add(mapper.map(origin, destination));
    }
    return result;
  }
}
