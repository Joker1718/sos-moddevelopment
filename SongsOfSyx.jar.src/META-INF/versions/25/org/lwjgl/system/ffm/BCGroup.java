/*      */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*      */ import java.lang.classfile.ClassBuilder;
/*      */ import java.lang.classfile.ClassFile;
/*      */ import java.lang.classfile.CodeBuilder;
/*      */ import java.lang.classfile.Label;
/*      */ import java.lang.classfile.MethodBuilder;
/*      */ import java.lang.classfile.TypeKind;
/*      */ import java.lang.constant.ClassDesc;
/*      */ import java.lang.constant.ConstantDescs;
/*      */ import java.lang.constant.MethodTypeDesc;
/*      */ import java.lang.foreign.GroupLayout;
/*      */ import java.lang.foreign.MemoryLayout;
/*      */ import java.lang.invoke.MethodHandle;
/*      */ import java.lang.invoke.MethodHandles;
/*      */ import java.lang.reflect.AccessFlag;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.SequencedMap;
/*      */ import java.util.function.Function;
/*      */ import org.lwjgl.system.ffm.BCDescriptors;
/*      */ import org.lwjgl.system.ffm.BCUtil;
/*      */ import org.lwjgl.system.ffm.FFM;
/*      */ import org.lwjgl.system.ffm.FFMCharset;
/*      */ import org.lwjgl.system.ffm.FFMConfig;
/*      */ import org.lwjgl.system.ffm.FFMSize;
/*      */ import org.lwjgl.system.ffm.Group;
/*      */ 
/*      */ final class BCGroup {
/*   31 */   private static final Collector<CharSequence, ?, String> SEMI_COLON = Collectors.joining(";");
/*      */   
/*      */   private static final MethodHandle CHECK_ADDRESS;
/*      */ 
/*      */   
/*      */   private static RuntimeException memberException(String message, Class<?> groupInterface, String member) {
/*   37 */     return new IllegalStateException(String.format("%s (%s::%s)", new Object[] { message, groupInterface.getSimpleName(), member }));
/*      */   }
/*      */   
/*      */   private static RuntimeException methodException(String message, Method method) {
/*   41 */     return new IllegalStateException(String.format("%s (%s::%s)", new Object[] { message, method.getDeclaringClass(), method.getName() }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static MethodHandles.Lookup bootstrapImplementation(FFMConfig config, Class<?> groupInterface, GroupLayout layout, FFM.GroupBinderBuilder<?, ?, ?, ?> builder) {
/*   50 */     ClassDesc thisClass = ClassDesc.of(groupInterface
/*   51 */         .getPackageName(), groupInterface
/*   52 */         .getSimpleName() + "Impl");
/*      */     
/*   54 */     byte[] bytecode = ClassFile.of().build(thisClass, classBuilder -> {
/*      */           ClassDesc groupDesc = groupInterface.describeConstable().orElseThrow();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           classBuilder.withVersion(ClassFile.latestMajorVersion(), ClassFile.latestMinorVersion()).withFlags(new AccessFlag[] { AccessFlag.PUBLIC, AccessFlag.FINAL }).withSuperclass(BCDescriptors.CD_Record).withInterfaceSymbols(new ClassDesc[] { groupDesc }).withField("address", ConstantDescs.CD_long, 18).withMethod("<init>", BCDescriptors.MTD_void_long, 0, ());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           SequencedMap<String, List<Method>> memberMap = compileMemberAccessors(groupInterface, layout);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*   79 */           boolean hasPrivateGetters = (builder.equals == null || builder.hashCode == null || builder.toString == null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           LinkedHashMap<String, Method> getters = new LinkedHashMap<>(memberMap.size());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           for (Map.Entry<String, List<Method>> member : memberMap.entrySet()) {
/*      */             String memberName = member.getKey();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             List<Method> methods = member.getValue();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             int getterCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             int nonCanonicalCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             for (Method method : methods) {
/*      */               if (method.getParameterCount() != 0) {
/*      */                 continue;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (method.getReturnType() == void.class) {
/*      */                 throw methodException("Group getter returns void", method);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               getterCount++;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               nonCanonicalCount += registerCanonicalGetter(groupInterface, method, getters, memberName);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               MethodTypeDesc descriptor = BCUtil.getMethodTypeDesc(method);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               classBuilder.withMethod(method.getName(), descriptor, 17, ());
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             if (hasPrivateGetters && 1 < getterCount && getterCount == nonCanonicalCount) {
/*      */               throw memberException("Failed to find canonical getter for layout member", groupInterface, memberName);
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           classBuilder.with((ClassFileElement)RecordAttribute.of((RecordComponentInfo[])getters.sequencedValues().stream().map(()).toArray(())));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if (hasPrivateGetters) {
/*      */             for (Map.Entry<String, Method> member : getters.sequencedEntrySet()) {
/*      */               MemoryLayout.PathElement memberPath = MemoryLayout.PathElement.groupElement(member.getKey());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               MemoryLayout memberLayout = layout.select(new MemoryLayout.PathElement[] { memberPath });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (!(memberLayout instanceof AddressLayout)) {
/*      */                 continue;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               Method method = member.getValue();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (method.getReturnType() == long.class) {
/*      */                 continue;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               long memberOffset = layout.byteOffset(new MemoryLayout.PathElement[] { memberPath });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (builder.equals == null || builder.hashCode == null) {
/*      */                 classBuilder.withMethod("__address__" + method.getName(), BCDescriptors.MTD_long, 18, ());
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (builder.toString == null) {
/*      */                 classBuilder.withMethod("__toString__" + method.getName(), BCDescriptors.MTD_String, 18, ());
/*      */               }
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           for (Map.Entry<String, List<Method>> member : memberMap.entrySet()) {
/*      */             for (Method method : member.getValue()) {
/*      */               if (method.getParameterCount() == 0) {
/*      */                 continue;
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (method.getParameterCount() != 1) {
/*      */                 throw methodException("Setter must accept a single parameter", method);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               if (method.getReturnType() != method.getDeclaringClass()) {
/*      */                 throw methodException("Setter return type must be its declaring interface", method);
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               MethodTypeDesc descriptor = BCUtil.getMethodTypeDesc(method);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               classBuilder.withMethod(method.getName(), descriptor, 17, ());
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           String[] bootstrapArgs = hasPrivateGetters ? getBootstrapArgs(layout, getters) : null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           classBuilder.withMethod("equals", BCDescriptors.MTD_boolean_Object, 17, ()).withMethod("hashCode", BCDescriptors.MTD_int, 17, ()).withMethod("toString", BCDescriptors.MTD_String, 17, ());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if (Group.class.isAssignableFrom(groupInterface)) {
/*      */             ClassDesc layoutDesc = (layout instanceof java.lang.foreign.StructLayout) ? BCDescriptors.CD_StructLayout : BCDescriptors.CD_UnionLayout;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             classBuilder.withMethod("layout", BCDescriptors.MTD_GroupLayout, 17, ()).withMethod("copyFrom", BCDescriptors.MTD_Group_Group, 17, ()).withMethod("clear", BCDescriptors.MTD_Group, 17, ()).withMethod("get", BCDescriptors.MTD_Group_MemorySegment, 17, ()).withMethod("get", BCDescriptors.MTD_Group_MemorySegment_long, 17, ()).withMethod("getAtIndex", BCDescriptors.MTD_Group_MemorySegment_long, 17, ()).withMethod("set", BCDescriptors.MTD_Group_MemorySegment, 17, ()).withMethod("set", BCDescriptors.MTD_Group_MemorySegment_long, 17, ()).withMethod("setAtIndex", BCDescriptors.MTD_Group_MemorySegment_long, 17, ());
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if (Group.class.isAssignableFrom(groupInterface) || Pointer.class.isAssignableFrom(groupInterface)) {
/*      */             classBuilder.withMethod("address", BCDescriptors.MTD_long, 17, ());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if (NativeResource.class.isAssignableFrom(groupInterface)) {
/*      */             classBuilder.withMethod("free", ConstantDescs.MTD_void, 17, ());
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  699 */     if (config.debugGenerator) {
/*  700 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  705 */       return config.lookup.defineHiddenClassWithClassData(bytecode, List.of(layout, 
/*      */             
/*  707 */             (builder.equals != null) ? builder.equals : BCUtil.EMPTY_SLOT, 
/*  708 */             (builder.hashCode != null) ? builder.hashCode : BCUtil.EMPTY_SLOT, 
/*  709 */             (builder.toString != null) ? builder.toString : BCUtil.EMPTY_SLOT), true, new MethodHandles.Lookup.ClassOption[0]);
/*      */     }
/*  711 */     catch (Error|RuntimeException e) {
/*  712 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*  713 */       throw e;
/*  714 */     } catch (Exception e) {
/*  715 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*  716 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static SequencedMap<String, List<Method>> compileMemberAccessors(Class<?> groupInterface, GroupLayout layout) {
/*  721 */     LinkedHashMap<String, List<Method>> memberMap = new LinkedHashMap<>(layout.memberLayouts().size());
/*      */     
/*  723 */     HashMap<String, List<Method>> methods = new HashMap<>(layout.memberLayouts().size());
/*  724 */     for (Method method : groupInterface.getMethods()) {
/*  725 */       if (!Modifier.isStatic(method.getModifiers()) && !method.isDefault()) {
/*      */ 
/*      */ 
/*      */         
/*  729 */         Class<?> declaringClass = method.getDeclaringClass();
/*  730 */         if (declaringClass != Object.class && declaringClass != Group.class && declaringClass != Pointer.class && declaringClass != NativeResource.class) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  739 */           checkAccessorAliasing(groupInterface, method);
/*  740 */           String name = BCUtil.getNativeName(method);
/*      */           
/*  742 */           ((List<Method>)methods
/*  743 */             .computeIfAbsent(name, paramString -> new ArrayList(4)))
/*  744 */             .add(method);
/*      */         } 
/*      */       } 
/*  747 */     }  for (MemoryLayout member : layout.memberLayouts()) {
/*  748 */       String name = member.name().orElse(null);
/*  749 */       if (name == null) {
/*      */         continue;
/*      */       }
/*      */       
/*  753 */       List<Method> memberAccessors = methods.get(name);
/*  754 */       if (memberAccessors != null) {
/*  755 */         memberMap.put(name, memberAccessors);
/*      */       }
/*      */     } 
/*      */     
/*  759 */     for (Map.Entry<String, List<Method>> method : methods.entrySet()) {
/*  760 */       if (!memberMap.containsKey(method.getKey())) {
/*  761 */         throw memberException("No layout member found with this name", groupInterface, (String)method.getKey());
/*      */       }
/*      */     } 
/*      */     
/*  765 */     return memberMap;
/*      */   }
/*      */   
/*      */   private static int registerCanonicalGetter(Class<?> groupInterface, Method method, LinkedHashMap<String, Method> getters, String memberName) {
/*  769 */     if (method.isAnnotationPresent((Class)FFMCanonical.class)) {
/*  770 */       Method canonical = getters.get(memberName);
/*  771 */       if (canonical != null && canonical.isAnnotationPresent((Class)FFMCanonical.class)) {
/*  772 */         throw memberException("Multiple canonical getters found", groupInterface, memberName);
/*      */       }
/*  774 */       getters.put(memberName, method);
/*  775 */     } else if (memberName.equals(method.getName())) {
/*  776 */       Method canonical = getters.get(memberName);
/*  777 */       if (canonical == null || !canonical.isAnnotationPresent((Class)FFMCanonical.class)) {
/*  778 */         getters.put(memberName, method);
/*      */       }
/*      */     } else {
/*  781 */       getters.putIfAbsent(memberName, method);
/*  782 */       return 1;
/*      */     } 
/*  784 */     return 0;
/*      */   }
/*      */   
/*      */   private static void checkAccessorAliasing(Class<?> groupInterface, Method method) {
/*  788 */     switch (method.getName()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case "equals":
/*      */       case "hashCode":
/*      */       case "toString":
/*  797 */         throw methodException("Group accessor name aliases supertype method and must be changed with @FFMName", method);case "address": if (Group.class.isAssignableFrom(groupInterface) || Pointer.class.isAssignableFrom(groupInterface)) throw methodException("Group accessor name aliases supertype method and must be changed with @FFMName", method);  break;case "layout": case "clear": case "sizeof": case "alignof": case "asSegment": if (Group.class.isAssignableFrom(groupInterface)) throw methodException("Group accessor name aliases supertype method and must be changed with @FFMName", method);
/*      */         
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static ClassDesc groupDesc(FFMConfig.BinderField binderField) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: invokevirtual binder : ()Lorg/lwjgl/system/ffm/Binder;
/*      */     //   4: astore_1
/*      */     //   5: aload_1
/*      */     //   6: dup
/*      */     //   7: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   10: pop
/*      */     //   11: astore_2
/*      */     //   12: iconst_0
/*      */     //   13: istore_3
/*      */     //   14: aload_2
/*      */     //   15: iload_3
/*      */     //   16: <illegal opcode> typeSwitch : (Lorg/lwjgl/system/ffm/Binder;I)I
/*      */     //   21: lookupswitch default -> 60, 0 -> 48, 1 -> 54
/*      */     //   48: getstatic org/lwjgl/system/ffm/BCDescriptors.CD_StructBinder : Ljava/lang/constant/ClassDesc;
/*      */     //   51: goto -> 82
/*      */     //   54: getstatic org/lwjgl/system/ffm/BCDescriptors.CD_UnionBinder : Ljava/lang/constant/ClassDesc;
/*      */     //   57: goto -> 82
/*      */     //   60: new java/lang/UnsupportedOperationException
/*      */     //   63: dup
/*      */     //   64: aload_1
/*      */     //   65: invokeinterface getClass : ()Ljava/lang/Class;
/*      */     //   70: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   73: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   78: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   81: athrow
/*      */     //   82: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #802	-> 0
/*      */     //   #803	-> 5
/*      */     //   #804	-> 48
/*      */     //   #805	-> 54
/*      */     //   #806	-> 60
/*      */     //   #803	-> 82
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   0	83	0	binderField	Lorg/lwjgl/system/ffm/FFMConfig$BinderField;
/*      */     //   5	78	1	binder	Lorg/lwjgl/system/ffm/Binder;
/*      */     // Local variable type table:
/*      */     //   start	length	slot	name	signature
/*      */     //   5	78	1	binder	Lorg/lwjgl/system/ffm/Binder<*>;
/*      */   }
/*      */ 
/*      */   
/*      */   private static CodeBuilder buildMemberAddress(CodeBuilder cb, ClassDesc thisClass, long memberOffset) {
/*  811 */     cb
/*  812 */       .aload(cb.receiverSlot())
/*  813 */       .getfield(thisClass, "address", ConstantDescs.CD_long);
/*      */     
/*  815 */     if (memberOffset != 0L) {
/*  816 */       cb
/*  817 */         .loadConstant(memberOffset)
/*  818 */         .ladd();
/*      */     }
/*      */     
/*  821 */     return cb;
/*      */   }
/*      */   
/*      */   private static void buildNullPointerCheck(CodeBuilder cb) {
/*  825 */     if (Checks.DEBUG) {
/*  826 */       cb
/*  827 */         .dup2()
/*  828 */         .lconst_0()
/*  829 */         .lcmp()
/*  830 */         .ifThen(Opcode.IFEQ, bcb -> bcb.new_(BCDescriptors.CD_NullPointerException).dup().ldc("Pointer value is NULL").invokespecial(BCDescriptors.CD_NullPointerException, "<init>", BCDescriptors.MTD_void_String).athrow());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends CodeBuilder> T buildAutoSize(T cb, ClassDesc groupDesc, SequencedMap<String, List<Method>> memberMap, Method method, FFMSize autoSize, MemoryLayout elementLayout) {
/*  847 */     Method sizeGetter = (Method)((List)memberMap.get(autoSize.value())).stream().filter(it -> it.getReturnType().isPrimitive()).findFirst().orElseThrow(() -> new IllegalStateException("The FFMSize reference \"" + autoSize.value() + "\" not found for " + String.valueOf(method)));
/*      */     
/*  849 */     MethodTypeDesc mtd = BCUtil.getMethodTypeDesc(sizeGetter);
/*  850 */     cb
/*  851 */       .aload(cb.receiverSlot())
/*  852 */       .invokeinterface(groupDesc, sizeGetter.getName(), mtd);
/*  853 */     if (mtd.returnType() != ConstantDescs.CD_long) {
/*  854 */       if (mtd.returnType() == ConstantDescs.CD_int) {
/*  855 */         cb
/*  856 */           .i2l()
/*  857 */           .loadConstant(4294967295L)
/*  858 */           .land();
/*  859 */       } else if (mtd.returnType() == ConstantDescs.CD_short || mtd.returnType() == ConstantDescs.CD_char) {
/*  860 */         cb
/*  861 */           .loadConstant(65535)
/*  862 */           .iand()
/*  863 */           .i2l();
/*  864 */       } else if (mtd.returnType() == ConstantDescs.CD_byte) {
/*  865 */         cb
/*  866 */           .loadConstant(255)
/*  867 */           .iand()
/*  868 */           .i2l();
/*      */       } else {
/*  870 */         throw methodException("Unsupported FFMSize getter type: " + String.valueOf(sizeGetter), method);
/*      */       } 
/*      */     }
/*  873 */     long byteSize = elementLayout.byteSize();
/*  874 */     if (byteSize != 1L) {
/*  875 */       cb
/*  876 */         .loadConstant(byteSize)
/*  877 */         .lmul();
/*      */     }
/*  879 */     return cb;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends CodeBuilder> T buildMemorySegmentReinterpret(T cb, ClassDesc groupDesc, SequencedMap<String, List<Method>> memberMap, Method method, AddressLayout addressLayout) {
/*  887 */     MemoryLayout targetLayout = addressLayout.targetLayout().orElseThrow();
/*  888 */     FFMSize autoSize = method.<FFMSize>getAnnotation(FFMSize.class);
/*  889 */     if (autoSize != null) {
/*  890 */       buildAutoSize(cb, groupDesc, memberMap, method, autoSize, targetLayout)
/*  891 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */     } else {
/*  893 */       cb
/*  894 */         .loadConstant(targetLayout.byteSize())
/*  895 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */     } 
/*  897 */     return cb;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends CodeBuilder> T buildStringGetter(T cb, ClassDesc groupDesc, SequencedMap<String, List<Method>> memberMap, Method method, FFMCharset.Type charset) {
/*  904 */     cb.invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true);
/*  905 */     FFMSize autoSize = method.<FFMSize>getAnnotation(FFMSize.class);
/*  906 */     if (autoSize != null) {
/*  907 */       int arraySlot = cb.allocateLocal(TypeKind.REFERENCE);
/*  908 */       buildAutoSize(cb, groupDesc, memberMap, method, autoSize, charset.layout)
/*  909 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/*  910 */         .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/*  911 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "toArray", BCDescriptors.MTD_byteArray_ValueLayout$OfByte)
/*  912 */         .astore(arraySlot)
/*  913 */         .new_(ConstantDescs.CD_String)
/*  914 */         .dup()
/*  915 */         .aload(arraySlot);
/*  916 */       BCUtil.buildCharsetInstance((CodeBuilder)cb, charset)
/*  917 */         .invokespecial(ConstantDescs.CD_String, "<init>", BCDescriptors.MTD_void_byteArray_Charset);
/*      */     } else {
/*  919 */       cb
/*  920 */         .loadConstant(Long.MAX_VALUE)
/*  921 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/*  922 */         .lconst_0();
/*  923 */       BCUtil.buildCharsetInstance((CodeBuilder)cb, charset)
/*  924 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "getString", BCDescriptors.MTD_String_long_Charset);
/*      */     } 
/*  926 */     return cb;
/*      */   }
/*      */   
/*      */   private static <T extends CodeBuilder> T buildGetFromMemorySegment(T cb, ClassDesc thisClass, Function<T, T> codeAddress) {
/*  930 */     cb
/*  931 */       .aload(cb.receiverSlot())
/*  932 */       .dup()
/*  933 */       .new_(thisClass)
/*  934 */       .dup();
/*  935 */     ((CodeBuilder)codeAddress.apply(cb))
/*  936 */       .invokespecial(thisClass, "<init>", BCDescriptors.MTD_void_long)
/*  937 */       .invokevirtual(thisClass, "copyFrom", BCDescriptors.MTD_Group_Group)
/*  938 */       .areturn();
/*  939 */     return cb;
/*      */   }
/*      */   
/*      */   private static <T extends CodeBuilder> T buildSetFromMemorySegment(T cb, ClassDesc thisClass, Function<T, T> codeAddress) {
/*  943 */     cb
/*  944 */       .new_(thisClass)
/*  945 */       .dup();
/*  946 */     ((CodeBuilder)codeAddress.apply(cb))
/*  947 */       .invokespecial(thisClass, "<init>", BCDescriptors.MTD_void_long)
/*  948 */       .aload(cb.receiverSlot())
/*  949 */       .invokevirtual(thisClass, "copyFrom", BCDescriptors.MTD_Group_Group)
/*  950 */       .areturn();
/*  951 */     return cb;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <T, L extends GroupLayout, M extends org.lwjgl.system.ffm.GroupBinder<L, T>> M bootstrap(FFM.GroupBinderBuilder<T, L, M, ?> builder, long byteAlignment) {
/*      */     MethodHandle implementationConstructor, implementationAddress;
/*  959 */     Class<T> groupInterface = builder.groupInterface;
/*      */     
/*  961 */     SequencedMap<String, MemoryLayout> members = builder.members;
/*      */     
/*  963 */     Kind kind = builder.kind();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  969 */     GroupLayout tmp = kind.layout((MemoryLayout[])members.values().toArray((Object[])new MemoryLayout[0])).withName(BCUtil.getNativeName(groupInterface));
/*  970 */     if (tmp.byteAlignment() < byteAlignment) {
/*  971 */       tmp = tmp.withByteAlignment(byteAlignment);
/*      */     }
/*  973 */     GroupLayout layout = tmp;
/*      */ 
/*      */     
/*  976 */     FFMConfig config = FFM.getConfig(groupInterface);
/*      */ 
/*      */     
/*  979 */     boolean hasTracing = (config.traceConsumer != null);
/*  980 */     int featureFlags = hasTracing ? BCCall.FeatureFlag.FF_TRACING.mask : 0;
/*      */     
/*  982 */     if (config.debugGenerator) {
/*  983 */       APIUtil.apiLog("BOOTSTRAPPING " + kind.name() + " " + String.valueOf(groupInterface));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  988 */     MethodHandles.Lookup implementationLookup = bootstrapImplementation(config, groupInterface, layout, builder);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  995 */       implementationConstructor = implementationLookup.findConstructor(implementationLookup.lookupClass(), MethodType.methodType(void.class, long.class)).asType(MethodType.methodType(groupInterface, long.class));
/*      */       
/*  997 */       if (Checks.DEBUG)
/*      */       {
/*      */         
/* 1000 */         implementationConstructor = MethodHandles.filterArguments(implementationConstructor, 0, new MethodHandle[] {
/* 1001 */               MethodHandles.insertArguments(CHECK_ADDRESS, 1, new Object[] { Long.valueOf(layout.byteAlignment()) })
/*      */             });
/*      */       }
/*      */ 
/*      */       
/* 1006 */       implementationAddress = implementationLookup.findGetter(implementationLookup.lookupClass(), "address", long.class).asType(MethodType.methodType(long.class, groupInterface));
/* 1007 */     } catch (Error|RuntimeException e) {
/* 1008 */       throw e;
/* 1009 */     } catch (Exception e) {
/* 1010 */       throw new RuntimeException(e);
/*      */     } 
/*      */     
/* 1013 */     ClassDesc binderClass = ClassDesc.of(groupInterface
/* 1014 */         .getPackageName(), groupInterface
/* 1015 */         .getSimpleName() + "Binder");
/*      */     
/* 1017 */     byte[] bytecode = ClassFile.of().build(binderClass, classBuilder -> {
/*      */           BCUtil.startHiddenClass(classBuilder).withInterfaceSymbols(new ClassDesc[] { kind.binderDesc() });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           ClassDesc groupDesc = groupInterface.describeConstable().orElseThrow();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           MethodTypeDesc constructorDesc = MethodTypeDesc.of(groupDesc, new ClassDesc[] { ConstantDescs.CD_long });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           classBuilder.withMethod("layout", BCDescriptors.MTD_GroupLayout, 17, ()).withMethod("addressOf", BCDescriptors.MTD_long_Object, 17, ()).withMethod("ofAddress", BCDescriptors.MTD_Object_long, 17, ()).withMethod("copy", BCDescriptors.MTD_Object_Object_Object, 17, ()).withMethod("clear", BCDescriptors.MTD_Object_Object, 17, ()).withMethod("get", BCDescriptors.MTD_Object_MemorySegment, 17, ()).withMethod("get", BCDescriptors.MTD_Object_MemorySegment_long, 17, ()).withMethod("getAtIndex", BCDescriptors.MTD_Object_MemorySegment_long, 17, ());
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1085 */     if (config.debugGenerator) {
/* 1086 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 1091 */       MethodHandles.Lookup wrapperLookup = config.lookup.defineHiddenClassWithClassData(bytecode, 
/* 1092 */           List.of(layout, implementationAddress, implementationConstructor), true, new MethodHandles.Lookup.ClassOption[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1098 */       return (M)wrapperLookup.lookupClass()
/* 1099 */         .getDeclaredConstructor(new Class[0])
/* 1100 */         .newInstance(new Object[0]);
/* 1101 */     } catch (Error|RuntimeException e) {
/* 1102 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 1103 */       throw e;
/* 1104 */     } catch (Exception e) {
/* 1105 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 1106 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static String[] getBootstrapArgs(GroupLayout layout, LinkedHashMap<String, Method> getters) {
/* 1112 */     String bootstrapNames = getters.sequencedKeySet().stream().collect(SEMI_COLON);
/*      */ 
/*      */     
/* 1115 */     Stream.Builder<String> bootstrapArgsBuilder = Stream.<String>builder().add(bootstrapNames);
/*      */     
/* 1117 */     getters
/* 1118 */       .sequencedEntrySet()
/* 1119 */       .forEach(member -> {
/*      */           Method method = (Method)member.getValue();
/*      */           
/*      */           MemoryLayout.PathElement memberPath = MemoryLayout.PathElement.groupElement((String)member.getKey());
/*      */           
/*      */           MemoryLayout memberLayout = layout.select(new MemoryLayout.PathElement[] { memberPath });
/* 1125 */           bootstrapArgsBuilder.add((memberLayout instanceof AddressLayout && method.getReturnType() != long.class) ? ("__address__" + method.getName()) : method.getName());
/*      */         });
/*      */ 
/*      */ 
/*      */     
/* 1130 */     return (String[])bootstrapArgsBuilder
/* 1131 */       .build()
/* 1132 */       .toArray(x$0 -> new String[x$0]);
/*      */   }
/*      */   
/*      */   private static <T extends CodeBuilder> T buildConstructor(T cb, MethodTypeDesc constructorDesc, Function<T, T> codeAddress) {
/* 1136 */     cb.ldc(BCUtil.condyCDataAt(ConstantDescs.CD_MethodHandle, 2));
/* 1137 */     ((CodeBuilder)codeAddress.apply(cb))
/* 1138 */       .invokevirtual(ConstantDescs.CD_MethodHandle, "invokeExact", constructorDesc)
/* 1139 */       .areturn();
/* 1140 */     return cb;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends CodeBuilder> void buildCopy(T cb, GroupLayout layout, Function<T, T> codeSrc, Function<T, T> codeDst, Function<T, T> codeRet) {
/* 1150 */     codeDst.apply(cb);
/*      */     
/* 1152 */     long byteSize = layout.byteSize();
/*      */     
/* 1154 */     if (512L < byteSize || BCUtil.JAVA_VERSION == 25) {
/*      */ 
/*      */       
/* 1157 */       if (byteSize < BCUtil.NATIVE_THRESHOLD_COPY || (byteSize & 0x1L) != 0L) {
/*      */         
/* 1159 */         cb
/* 1160 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1161 */           .loadConstant(byteSize)
/* 1162 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */         
/* 1164 */         ((CodeBuilder)codeSrc.apply(cb))
/* 1165 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1166 */           .loadConstant(byteSize)
/* 1167 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */         
/* 1169 */         cb
/* 1170 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "copyFrom", BCDescriptors.MTD_MemorySegment_MemorySegment)
/* 1171 */           .pop();
/*      */       } else {
/*      */         
/* 1174 */         int dstSlot = cb.allocateLocal(TypeKind.LONG);
/* 1175 */         cb
/* 1176 */           .dup2()
/* 1177 */           .lstore(dstSlot)
/* 1178 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1179 */           .loadConstant(byteSize - 1L)
/* 1180 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */         
/* 1182 */         int srcSlot = cb.allocateLocal(TypeKind.LONG);
/* 1183 */         ((CodeBuilder)codeSrc.apply(cb))
/* 1184 */           .dup2()
/* 1185 */           .lstore(srcSlot)
/* 1186 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1187 */           .loadConstant(byteSize - 1L)
/* 1188 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long);
/*      */         
/* 1190 */         cb
/* 1191 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "copyFrom", BCDescriptors.MTD_MemorySegment_MemorySegment)
/* 1192 */           .pop();
/*      */         
/* 1194 */         cb
/* 1195 */           .lload(dstSlot)
/* 1196 */           .loadConstant(byteSize - 1L)
/* 1197 */           .ladd()
/* 1198 */           .lload(srcSlot)
/* 1199 */           .loadConstant(byteSize - 1L)
/* 1200 */           .ladd()
/* 1201 */           .invokestatic(BCDescriptors.CD_MemoryUtil, "memGetByte", BCDescriptors.MTD_byte_long)
/* 1202 */           .invokestatic(BCDescriptors.CD_MemoryUtil, "memPutByte", BCDescriptors.MTD_void_long_byte);
/*      */       } 
/*      */     } else {
/*      */       
/* 1206 */       int dstSlot = cb.allocateLocal(TypeKind.REFERENCE);
/* 1207 */       cb
/* 1208 */         .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1209 */         .loadConstant(byteSize)
/* 1210 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1211 */         .astore(dstSlot);
/*      */       
/* 1213 */       int srcSlot = cb.allocateLocal(TypeKind.REFERENCE);
/* 1214 */       ((CodeBuilder)codeSrc.apply(cb))
/* 1215 */         .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1216 */         .loadConstant(byteSize)
/* 1217 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1218 */         .astore(srcSlot);
/*      */ 
/*      */       
/* 1221 */       if (16L <= byteSize) {
/* 1222 */         int offsetSlot = cb.allocateLocal(TypeKind.LONG);
/*      */         
/* 1224 */         cb
/* 1225 */           .lconst_0()
/* 1226 */           .lstore(offsetSlot);
/*      */         
/* 1228 */         Label loopStart = cb.newBoundLabel();
/* 1229 */         Label loopEnd = cb.newLabel();
/*      */         
/* 1231 */         cb
/* 1232 */           .lload(offsetSlot)
/* 1233 */           .loadConstant(byteSize & 0xFFFFFFFFFFFFFFF8L)
/* 1234 */           .lcmp()
/* 1235 */           .ifge(loopEnd)
/* 1236 */           .aload(dstSlot)
/* 1237 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1238 */           .lload(offsetSlot)
/* 1239 */           .aload(srcSlot)
/* 1240 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1241 */           .lload(offsetSlot)
/* 1242 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", BCDescriptors.MTD_long_ValueLayout$OfLong_long)
/* 1243 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfLong_long_long)
/* 1244 */           .lload(offsetSlot)
/* 1245 */           .loadConstant(8L)
/* 1246 */           .ladd()
/* 1247 */           .lstore(offsetSlot)
/* 1248 */           .goto_(loopStart)
/* 1249 */           .labelBinding(loopEnd);
/* 1250 */       } else if (8L <= byteSize) {
/* 1251 */         cb
/* 1252 */           .aload(dstSlot)
/* 1253 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1254 */           .lconst_0()
/* 1255 */           .aload(srcSlot)
/* 1256 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1257 */           .lconst_0()
/* 1258 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", BCDescriptors.MTD_long_ValueLayout$OfLong_long)
/* 1259 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfLong_long_long);
/*      */       } 
/*      */       
/* 1262 */       long offset = byteSize & 0xFFFFFFFFFFFFFFF8L;
/* 1263 */       if (offset < (byteSize & 0xFFFFFFFFFFFFFFFCL)) {
/* 1264 */         cb
/* 1265 */           .aload(dstSlot)
/* 1266 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_INT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfInt)
/* 1267 */           .loadConstant(offset)
/* 1268 */           .aload(srcSlot)
/* 1269 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_INT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfInt)
/* 1270 */           .loadConstant(offset)
/* 1271 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", BCDescriptors.MTD_int_ValueLayout$OfInt_long)
/* 1272 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfInt_long_int);
/* 1273 */         offset += 4L;
/*      */       } 
/*      */       
/* 1276 */       if (offset < (byteSize & 0xFFFFFFFFFFFFFFFEL)) {
/* 1277 */         cb
/* 1278 */           .aload(dstSlot)
/* 1279 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_SHORT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfShort)
/* 1280 */           .loadConstant(offset)
/* 1281 */           .aload(srcSlot)
/* 1282 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_SHORT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfShort)
/* 1283 */           .loadConstant(offset)
/* 1284 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", BCDescriptors.MTD_short_ValueLayout$OfShort_long)
/* 1285 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfShort_long_short);
/* 1286 */         offset += 2L;
/*      */       } 
/*      */       
/* 1289 */       if (offset < byteSize) {
/* 1290 */         cb
/* 1291 */           .aload(dstSlot)
/* 1292 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/* 1293 */           .loadConstant(offset)
/* 1294 */           .aload(srcSlot)
/* 1295 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/* 1296 */           .loadConstant(offset)
/* 1297 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "get", BCDescriptors.MTD_byte_ValueLayout$OfByte_long)
/* 1298 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfByte_long_byte);
/*      */       }
/*      */     } 
/* 1301 */     ((CodeBuilder)codeRet.apply(cb))
/* 1302 */       .areturn();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends CodeBuilder> void buildClear(T cb, GroupLayout layout, Function<T, T> codeReceiver, Function<T, T> codeReturn) {
/* 1311 */     codeReceiver.apply(cb);
/*      */     
/* 1313 */     long byteSize = layout.byteSize();
/*      */     
/* 1315 */     if (1024L < byteSize || (BCUtil.JAVA_VERSION == 25 && (byteSize <= BCUtil.NATIVE_THRESHOLD_FILL || 64L < byteSize))) {
/*      */ 
/*      */       
/* 1318 */       if (byteSize < BCUtil.NATIVE_THRESHOLD_FILL || (byteSize & 0x1L) != 0L) {
/* 1319 */         cb
/* 1320 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1321 */           .loadConstant(byteSize)
/* 1322 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1323 */           .iconst_0()
/* 1324 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "fill", BCDescriptors.MTD_MemorySegment_byte)
/* 1325 */           .pop();
/*      */       } else {
/* 1327 */         int addressSlot = cb.allocateLocal(TypeKind.LONG);
/* 1328 */         cb
/* 1329 */           .lstore(addressSlot);
/*      */         
/* 1331 */         cb
/* 1332 */           .lload(addressSlot)
/* 1333 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1334 */           .loadConstant(byteSize - 1L)
/* 1335 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1336 */           .iconst_0()
/* 1337 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "fill", BCDescriptors.MTD_MemorySegment_byte)
/* 1338 */           .pop();
/*      */         
/* 1340 */         cb
/* 1341 */           .lload(addressSlot)
/* 1342 */           .loadConstant(byteSize - 1L)
/* 1343 */           .ladd()
/* 1344 */           .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1345 */           .lconst_1()
/* 1346 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1347 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/* 1348 */           .lconst_0()
/* 1349 */           .iconst_0()
/* 1350 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfByte_long_byte);
/*      */       } 
/*      */     } else {
/*      */       
/* 1354 */       int segmentSlot = cb.allocateLocal(TypeKind.REFERENCE);
/* 1355 */       cb
/* 1356 */         .invokestatic(BCDescriptors.CD_MemorySegment, "ofAddress", BCDescriptors.MTD_MemorySegment_long, true)
/* 1357 */         .loadConstant(byteSize)
/* 1358 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "reinterpret", BCDescriptors.MTD_MemorySegment_long)
/* 1359 */         .astore(segmentSlot);
/*      */ 
/*      */       
/* 1362 */       if (16L <= byteSize) {
/* 1363 */         int offsetSlot = cb.allocateLocal(TypeKind.LONG);
/*      */         
/* 1365 */         cb
/* 1366 */           .lconst_0()
/* 1367 */           .lstore(offsetSlot);
/*      */         
/* 1369 */         Label loopStart = cb.newBoundLabel();
/* 1370 */         Label loopEnd = cb.newLabel();
/*      */         
/* 1372 */         cb
/* 1373 */           .lload(offsetSlot)
/* 1374 */           .loadConstant(byteSize & 0xFFFFFFFFFFFFFFF8L)
/* 1375 */           .lcmp()
/* 1376 */           .ifge(loopEnd)
/* 1377 */           .aload(segmentSlot)
/* 1378 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1379 */           .lload(offsetSlot)
/* 1380 */           .lconst_0()
/* 1381 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfLong_long_long)
/* 1382 */           .lload(offsetSlot)
/* 1383 */           .loadConstant(8L)
/* 1384 */           .ladd()
/* 1385 */           .lstore(offsetSlot)
/* 1386 */           .goto_(loopStart)
/* 1387 */           .labelBinding(loopEnd);
/* 1388 */       } else if (8L <= byteSize) {
/* 1389 */         cb
/* 1390 */           .aload(segmentSlot)
/* 1391 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_LONG_UNALIGNED", BCDescriptors.CD_ValueLayout$OfLong)
/* 1392 */           .lconst_0()
/* 1393 */           .lconst_0()
/* 1394 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfLong_long_long);
/*      */       } 
/*      */       
/* 1397 */       long offset = byteSize & 0xFFFFFFFFFFFFFFF8L;
/* 1398 */       if (offset < (byteSize & 0xFFFFFFFFFFFFFFFCL)) {
/* 1399 */         cb
/* 1400 */           .aload(segmentSlot)
/* 1401 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_INT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfInt)
/* 1402 */           .loadConstant(offset)
/* 1403 */           .iconst_0()
/* 1404 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfInt_long_int);
/* 1405 */         offset += 4L;
/*      */       } 
/*      */       
/* 1408 */       if (offset < (byteSize & 0xFFFFFFFFFFFFFFFEL)) {
/* 1409 */         cb
/* 1410 */           .aload(segmentSlot)
/* 1411 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_SHORT_UNALIGNED", BCDescriptors.CD_ValueLayout$OfShort)
/* 1412 */           .loadConstant(offset)
/* 1413 */           .iconst_0()
/* 1414 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfShort_long_short);
/* 1415 */         offset += 2L;
/*      */       } 
/*      */       
/* 1418 */       if (offset < byteSize) {
/* 1419 */         cb
/* 1420 */           .aload(segmentSlot)
/* 1421 */           .getstatic(BCDescriptors.CD_ValueLayout, "JAVA_BYTE", BCDescriptors.CD_ValueLayout$OfByte)
/* 1422 */           .loadConstant(offset)
/* 1423 */           .iconst_0()
/* 1424 */           .invokeinterface(BCDescriptors.CD_MemorySegment, "set", BCDescriptors.MTD_void_ValueLayout$OfByte_long_byte);
/*      */       }
/*      */     } 
/*      */     
/* 1428 */     ((CodeBuilder)codeReturn.apply(cb))
/* 1429 */       .areturn();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CodeBuilder> void buildGetMemorySegment(T cb, FFMConfig config, ClassDesc layoutDesc, Function<T, T> constructorCode) {
/* 1439 */     if (config.checks)
/*      */     {
/* 1441 */       cb
/* 1442 */         .aload(cb.parameterSlot(0))
/* 1443 */         .lconst_0()
/* 1444 */         .ldc(BCUtil.condyCDataAt(layoutDesc, 0))
/* 1445 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "asSlice", BCDescriptors.MTD_MemorySegment_long_MemoryLayout)
/* 1446 */         .pop();
/*      */     }
/* 1448 */     constructorCode.apply(cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CodeBuilder> void buildGetMemorySegmentAtOffset(T cb, FFMConfig config, ClassDesc layoutDesc, Function<T, T> constructorCode) {
/* 1458 */     if (config.checks)
/*      */     {
/* 1460 */       cb
/* 1461 */         .aload(cb.parameterSlot(0))
/* 1462 */         .lload(cb.parameterSlot(1))
/* 1463 */         .ldc(BCUtil.condyCDataAt(layoutDesc, 0))
/* 1464 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "asSlice", BCDescriptors.MTD_MemorySegment_long_MemoryLayout)
/* 1465 */         .pop();
/*      */     }
/* 1467 */     constructorCode.apply(cb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CodeBuilder> void buildGetMemorySegmentAtIndex(T cb, FFMConfig config, ClassDesc layoutDesc, Function<T, T> constructorCode) {
/* 1477 */     if (config.checks)
/*      */     {
/* 1479 */       cb
/* 1480 */         .aload(cb.parameterSlot(0))
/* 1481 */         .lload(cb.parameterSlot(1))
/* 1482 */         .ldc(BCUtil.condyCDataAt(layoutDesc, 0))
/* 1483 */         .invokeinterface(BCDescriptors.CD_GroupLayout, "byteSize", BCDescriptors.MTD_long)
/* 1484 */         .lmul()
/* 1485 */         .ldc(BCUtil.condyCDataAt(layoutDesc, 0))
/* 1486 */         .invokeinterface(BCDescriptors.CD_MemorySegment, "asSlice", BCDescriptors.MTD_MemorySegment_long_MemoryLayout)
/* 1487 */         .pop();
/*      */     }
/* 1489 */     constructorCode.apply(cb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     try {
/* 1496 */       CHECK_ADDRESS = MethodHandles.lookup().findStatic(org.lwjgl.system.ffm.BCGroup.class, "checkAddress", MethodType.methodType(long.class, long.class, new Class[] { long.class }));
/* 1497 */     } catch (NoSuchMethodException|IllegalAccessException e) {
/* 1498 */       throw new RuntimeException(e);
/*      */     } 
/*      */   }
/*      */   private static long checkAddress(long address, long alignment) {
/* 1502 */     if (address == 0L) {
/* 1503 */       throw new NullPointerException("Group instance cannot be instantiated with a NULL address");
/*      */     }
/* 1505 */     if ((address & alignment - 1L) != 0L) {
/* 1506 */       throw new IllegalArgumentException("Group instance address is not properly aligned to " + alignment + " bytes: 0x" + Long.toHexString(address));
/*      */     }
/* 1508 */     return address;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCGroup.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */