/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.foreign.SymbolLookup;
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
/*     */ import org.lwjgl.system.ffm.StructBinder;
/*     */ import org.lwjgl.system.ffm.TraceConsumer;
/*     */ import org.lwjgl.system.ffm.UnionBinder;
/*     */ import org.lwjgl.system.ffm.UpcallBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FFMConfig
/*     */ {
/*     */   final MethodHandles.Lookup lookup;
/*  30 */   final HashMap<Class<?>, BinderField> binders = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   final Class<? extends Annotation> nullableAnnotation;
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean nullableAnnotationOnType;
/*     */ 
/*     */ 
/*     */   
/*     */   final SymbolLookup symbolLookup;
/*     */ 
/*     */ 
/*     */   
/*     */   final TraceConsumer traceConsumer;
/*     */ 
/*     */ 
/*     */   
/*     */   final Predicate<Method> tracingFilter;
/*     */ 
/*     */ 
/*     */   
/*     */   final Function<Method, Boolean> criticalOverride;
/*     */ 
/*     */   
/*     */   final boolean checks;
/*     */ 
/*     */   
/*     */   final boolean debugGenerator;
/*     */ 
/*     */ 
/*     */   
/*     */   FFMConfig(Class<? extends Annotation> nullableAnnotation, MethodHandles.Lookup lookup, SymbolLookup symbolLookup, TraceConsumer traceConsumer, Predicate<Method> tracingFilter, Function<Method, Boolean> criticalOverride, boolean checks, boolean debugGenerator) {
/*  65 */     this.nullableAnnotation = nullableAnnotation;
/*  66 */     this.lookup = lookup;
/*  67 */     this.symbolLookup = symbolLookup;
/*  68 */     this.traceConsumer = traceConsumer;
/*  69 */     this.tracingFilter = tracingFilter;
/*  70 */     this.criticalOverride = criticalOverride;
/*  71 */     this.checks = checks;
/*  72 */     this.debugGenerator = debugGenerator;
/*     */     
/*  74 */     this.nullableAnnotationOnType = validateNullableAnnotationClass(nullableAnnotation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MethodHandles.Lookup getLookup() {
/*  83 */     return this.lookup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBinder(Class<?> type) {
/*  94 */     return this.binders.containsKey(type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> StructBinder<T> getStructBinder(Class<T> type) {
/* 108 */     return (StructBinder<T>)((BinderField)Objects.requireNonNull((T)this.binders.get(type))).binder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> UnionBinder<T> getUnionBinder(Class<T> type) {
/* 122 */     return (UnionBinder<T>)((BinderField)Objects.requireNonNull((T)this.binders.get(type))).binder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> UpcallBinder<T> getUpcallBinder(Class<T> type) {
/* 136 */     return (UpcallBinder<T>)((BinderField)Objects.requireNonNull((T)this.binders.get(type))).binder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends Annotation> getNullableAnnotation() {
/* 145 */     return this.nullableAnnotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SymbolLookup getSymbolLookup() {
/* 154 */     return this.symbolLookup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TraceConsumer getTraceConsumer() {
/* 163 */     return this.traceConsumer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<Method> getTracingFilter() {
/* 172 */     return this.tracingFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Function<Method, Boolean> getCriticalOverride() {
/* 181 */     return this.criticalOverride;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checks() {
/* 190 */     return this.checks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean debugGenerator() {
/* 199 */     return this.debugGenerator;
/*     */   }
/*     */   
/*     */   static boolean validateNullableAnnotationClass(Class<? extends Annotation> nullableAnnotation) {
/* 203 */     if (nullableAnnotation == null) {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     Retention retention = nullableAnnotation.<Retention>getDeclaredAnnotation(Retention.class);
/* 208 */     if (retention == null || retention.value() != RetentionPolicy.RUNTIME) {
/* 209 */       throw new IllegalStateException("Nullable annotation " + String.valueOf(nullableAnnotation) + " must have RUNTIME retention");
/*     */     }
/*     */     
/* 212 */     Target target = nullableAnnotation.<Target>getDeclaredAnnotation(Target.class);
/* 213 */     if (target != null) {
/* 214 */       List<ElementType> elementTypes = List.of(target.value());
/* 215 */       if (elementTypes.contains(ElementType.TYPE_USE)) {
/* 216 */         return true;
/*     */       }
/*     */       
/* 219 */       if (!elementTypes.contains(ElementType.METHOD) || !elementTypes.contains(ElementType.PARAMETER)) {
/* 220 */         throw new IllegalStateException("Nullable annotation " + String.valueOf(nullableAnnotation) + " must @Target either TYPE_USE or METHOD+PARAMETER");
/*     */       }
/*     */     } 
/* 223 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\FFMConfig.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */