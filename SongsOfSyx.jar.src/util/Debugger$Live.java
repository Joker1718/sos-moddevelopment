/*     */ package util;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Live
/*     */   implements Debugger
/*     */ {
/*  72 */   public ArrayListGrower<Debugger.Row> all = new ArrayListGrower();
/*  73 */   public int size = 0;
/*  74 */   private int indent = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Str debug(CharSequence name) {
/*  81 */     if (this.size >= 16384) {
/*  82 */       ((Debugger.Row)this.all.get(this.size)).name = "overflow...";
/*  83 */       return Str.TMP.clear();
/*     */     } 
/*  85 */     if (this.size >= this.all.size())
/*  86 */       this.all.add(new Debugger.Row()); 
/*  87 */     ((Debugger.Row)this.all.get(this.size)).name = name;
/*  88 */     ((Debugger.Row)this.all.get(this.size)).a = null;
/*  89 */     ((Debugger.Row)this.all.get(this.size)).indent = this.indent;
/*  90 */     Str s = ((Debugger.Row)this.all.get(this.size)).str;
/*  91 */     this.size++;
/*  92 */     return s.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug(CharSequence name, ACTION a) {
/*  97 */     debug(name);
/*  98 */     ((Debugger.Row)this.all.get(this.size - 1)).a = a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void title(CharSequence name) {
/* 104 */     debug(null).add(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debugObject(CharSequence name, Object o) {
/* 113 */     if (o == null) {
/* 114 */       debug(name).add("null");
/*     */       return;
/*     */     } 
/* 117 */     if (this.indent > 10) {
/* 118 */       debug(name).add("overflow...");
/*     */       return;
/*     */     } 
/* 121 */     debug(name).add('>');
/*     */ 
/*     */ 
/*     */     
/* 125 */     Class<?> clazz = o.getClass();
/* 126 */     this.indent++; byte b; int i; Field[] arrayOfField;
/* 127 */     for (i = (arrayOfField = clazz.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/*     */       
/* 129 */       if (!Modifier.isStatic(field.getModifiers())) {
/*     */ 
/*     */         
/* 132 */         field.setAccessible(true);
/*     */         
/*     */         try {
/* 135 */           Object value = field.get(o);
/*     */           
/* 137 */           if (value == null)
/* 138 */           { debug(field.getName()).add("null"); }
/* 139 */           else if (value instanceof Debugger.Debuggable) { Debugger.Debuggable dbg = (Debugger.Debuggable)value;
/* 140 */             debugObject(field.getName(), dbg); }
/*     */           else
/* 142 */           { debug(field.getName()).add(value.toString()); }
/*     */ 
/*     */         
/* 145 */         } catch (IllegalAccessException e) {
/* 146 */           debug(field.getName()).add("inaccessible");
/*     */         } 
/*     */       }  b++; }
/* 149 */      this.indent--;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 153 */     this.size = 0;
/* 154 */     this.indent = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\Debugger$Live.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */