/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.foreign.GroupLayout;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.SequencedMap;
/*     */ import java.util.function.BiPredicate;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.ToIntFunction;
/*     */ import org.lwjgl.system.ffm.BCGroup;
/*     */ import org.lwjgl.system.ffm.FFM;
/*     */ import org.lwjgl.system.ffm.GroupBinder;
/*     */ import org.lwjgl.system.ffm.mapping.DataMapping;
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
/*     */ public abstract class GroupBinderBuilder<T, L extends GroupLayout, M extends GroupBinder<L, T>, SELF extends FFM.GroupBinderBuilder<T, L, M, SELF>>
/*     */ {
/*     */   final Class<T> groupInterface;
/*     */   final Field binderField;
/* 382 */   final SequencedMap<String, MemoryLayout> members = new LinkedHashMap<>();
/*     */   
/*     */   BiPredicate<T, Object> equals;
/*     */   
/*     */   ToIntFunction<T> hashCode;
/*     */   
/*     */   Function<T, String> toString;
/*     */   
/*     */   protected boolean automaticPadding = true;
/*     */   
/*     */   protected boolean checkPadding = true;
/*     */   private int paddingIndex;
/*     */   protected long sizeof;
/*     */   protected long alignof;
/* 396 */   protected long packAlignment = Long.MAX_VALUE;
/*     */   private long alignas;
/*     */   
/*     */   protected GroupBinderBuilder(Class<T> groupInterface) {
/* 400 */     if (!groupInterface.isInterface()) {
/* 401 */       throw new UnsupportedOperationException("The binder must be parameterized with an interface");
/*     */     }
/*     */     
/* 404 */     if (groupInterface.isHidden()) {
/* 405 */       throw new UnsupportedOperationException("The binder must not be parameterized with a hidden interface");
/*     */     }
/*     */     
/* 408 */     if (groupInterface.isSealed()) {
/* 409 */       throw new UnsupportedOperationException("The binder must not be parameterized with a sealed interface");
/*     */     }
/*     */     
/* 412 */     if ((groupInterface.getTypeParameters()).length != 0) {
/* 413 */       throw new UnsupportedOperationException("The binder must not be parameterized with a generic interface");
/*     */     }
/*     */     
/* 416 */     this.groupInterface = groupInterface;
/* 417 */     this.binderField = FFM.findBinderField(groupInterface);
/*     */   }
/*     */ 
/*     */   
/*     */   abstract SELF self();
/*     */   
/*     */   protected static long align(long offset, long alignment) {
/* 424 */     return (offset - 1L | alignment - 1L) + 1L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract BCGroup.Kind kind();
/*     */ 
/*     */ 
/*     */   
/*     */   public M build() {
/* 434 */     long byteAlignment = Math.max(this.alignof, this.alignas);
/*     */     
/* 436 */     if (this.automaticPadding) {
/* 437 */       long sizeofAligned = align(this.sizeof, byteAlignment);
/* 438 */       if (sizeofAligned != this.sizeof) {
/* 439 */         padding(sizeofAligned - this.sizeof);
/*     */       }
/*     */     } 
/*     */     
/* 443 */     GroupBinder groupBinder = BCGroup.bootstrap(this, byteAlignment);
/*     */     
/* 445 */     if (this.checkPadding && 
/* 446 */       !isAligned(groupBinder.layout().byteSize(), groupBinder.layout().byteAlignment())) {
/* 447 */       throw new IllegalStateException("Group size is not a multiple of its alignment");
/*     */     }
/*     */ 
/*     */     
/* 451 */     return (M)groupBinder;
/*     */   }
/*     */   private static boolean isAligned(long offset, long alignment) {
/* 454 */     return ((offset & alignment - 1L) == 0L);
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
/*     */   public SELF automaticPadding(boolean enabled) {
/* 468 */     this.automaticPadding = enabled;
/* 469 */     return self();
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
/*     */   public SELF checkPadding(boolean enabled) {
/* 483 */     this.checkPadding = enabled;
/* 484 */     return self();
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
/*     */   public SELF pack(long alignment) {
/* 497 */     this.packAlignment = alignment;
/* 498 */     return self();
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
/*     */   public SELF alignas(long alignment) {
/* 512 */     this.alignas = alignment;
/* 513 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract SELF m(String paramString, DataMapping<?> paramDataMapping);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SELF addMember(String name, MemoryLayout layout) {
/* 527 */     MemoryLayout previous = this.members.put(name, layout.withName(name));
/* 528 */     if (previous != null) {
/* 529 */       throw new IllegalStateException("struct member '" + name + "' is already defined");
/*     */     }
/* 531 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SELF padding(long padding) {
/* 542 */     this.members.put("__padding__" + this.paddingIndex++, MemoryLayout.paddingLayout(padding));
/* 543 */     this.sizeof += padding;
/* 544 */     return self();
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
/*     */ 
/*     */   
/*     */   public SELF withEquals(BiPredicate<T, Object> equals) {
/* 560 */     this.equals = equals;
/* 561 */     return self();
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
/*     */ 
/*     */   
/*     */   public SELF withHashCode(ToIntFunction<T> hashCode) {
/* 577 */     this.hashCode = hashCode;
/* 578 */     return self();
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
/*     */ 
/*     */   
/*     */   public SELF withToString(Function<T, String> toString) {
/* 594 */     this.toString = toString;
/* 595 */     return self();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\FFM$GroupBinderBuilder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */