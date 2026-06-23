/*     */ package util;
/*     */ import init.sprite.UI.UI;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ public interface Debugger {
/*     */   Str debug(CharSequence paramCharSequence);
/*     */   
/*     */   void debug(CharSequence paramCharSequence, ACTION paramACTION);
/*     */   
/*     */   void title(CharSequence paramCharSequence);
/*     */   
/*     */   void debugObject(CharSequence paramCharSequence, Object paramObject);
/*     */   
/*     */   default void debugObject(Object o) {
/*  30 */     debugObject(o.getClass().getName(), o);
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface Debuggable
/*     */   {
/*     */     default void debug(CharSequence name, Debugger d) {
/*  37 */       d.debugObject(name, this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  42 */   public static final Debugger dummy = new Debugger()
/*     */     {
/*  44 */       private final Str tmp = new Str(128);
/*     */ 
/*     */ 
/*     */       
/*     */       public void title(CharSequence name) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public Str debug(CharSequence name) {
/*  53 */         this.tmp.clear();
/*  54 */         return this.tmp;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void debugObject(CharSequence name, Object o) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void debug(CharSequence name, ACTION a) {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Live
/*     */     implements Debugger
/*     */   {
/*  72 */     public ArrayListGrower<Debugger.Row> all = new ArrayListGrower();
/*  73 */     public int size = 0;
/*  74 */     private int indent = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Str debug(CharSequence name) {
/*  81 */       if (this.size >= 16384) {
/*  82 */         ((Debugger.Row)this.all.get(this.size)).name = "overflow...";
/*  83 */         return Str.TMP.clear();
/*     */       } 
/*  85 */       if (this.size >= this.all.size())
/*  86 */         this.all.add(new Debugger.Row()); 
/*  87 */       ((Debugger.Row)this.all.get(this.size)).name = name;
/*  88 */       ((Debugger.Row)this.all.get(this.size)).a = null;
/*  89 */       ((Debugger.Row)this.all.get(this.size)).indent = this.indent;
/*  90 */       Str s = ((Debugger.Row)this.all.get(this.size)).str;
/*  91 */       this.size++;
/*  92 */       return s.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public void debug(CharSequence name, ACTION a) {
/*  97 */       debug(name);
/*  98 */       ((Debugger.Row)this.all.get(this.size - 1)).a = a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void title(CharSequence name) {
/* 104 */       debug(null).add(name);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void debugObject(CharSequence name, Object o) {
/* 113 */       if (o == null) {
/* 114 */         debug(name).add("null");
/*     */         return;
/*     */       } 
/* 117 */       if (this.indent > 10) {
/* 118 */         debug(name).add("overflow...");
/*     */         return;
/*     */       } 
/* 121 */       debug(name).add('>');
/*     */ 
/*     */ 
/*     */       
/* 125 */       Class<?> clazz = o.getClass();
/* 126 */       this.indent++; byte b; int i; Field[] arrayOfField;
/* 127 */       for (i = (arrayOfField = clazz.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/*     */         
/* 129 */         if (!Modifier.isStatic(field.getModifiers())) {
/*     */ 
/*     */           
/* 132 */           field.setAccessible(true);
/*     */           
/*     */           try {
/* 135 */             Object value = field.get(o);
/*     */             
/* 137 */             if (value == null)
/* 138 */             { debug(field.getName()).add("null"); }
/* 139 */             else if (value instanceof Debugger.Debuggable) { Debugger.Debuggable dbg = (Debugger.Debuggable)value;
/* 140 */               debugObject(field.getName(), dbg); }
/*     */             else
/* 142 */             { debug(field.getName()).add(value.toString()); }
/*     */ 
/*     */           
/* 145 */           } catch (IllegalAccessException e) {
/* 146 */             debug(field.getName()).add("inaccessible");
/*     */           } 
/*     */         }  b++; }
/* 149 */        this.indent--;
/*     */     }
/*     */     
/*     */     public void clear() {
/* 153 */       this.size = 0;
/* 154 */       this.indent = 0;
/*     */     } }
/*     */   
/*     */   public static class Row {
/*     */     public CharSequence name;
/*     */     public final Str str;
/*     */     public int indent;
/*     */     public ACTION a;
/*     */     
/*     */     public Row() {
/* 164 */       this.str = new Str(64);
/* 165 */       this.indent = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class DebuggerSection
/*     */     extends GuiSection
/*     */   {
/* 172 */     private final ArrayListResize<Debugger.Row> filtered = new ArrayListResize(128);
/* 173 */     public final Debugger.Live debugger = new Debugger.Live();
/* 174 */     private final GInput sp = new GInput(new StringInputSprite(24, (UI.FONT()).S));
/*     */ 
/*     */ 
/*     */     
/*     */     public DebuggerSection(int height) {
/* 179 */       GTableBuilder bu = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries() {
/* 182 */             return Debugger.DebuggerSection.this.filtered.size();
/*     */           }
/*     */           
/*     */           public void click(int index) {
/* 186 */             if (((Debugger.Row)Debugger.DebuggerSection.this.filtered.get(index)).a != null) {
/* 187 */               ((Debugger.Row)Debugger.DebuggerSection.this.filtered.get(index)).a.exe();
/*     */             }
/*     */           }
/*     */         };
/*     */       
/* 192 */       bu.column(null, 800, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 196 */               return (RENDEROBJ)new RENDEROBJ.RenderImp(800, 24)
/*     */                 {
/*     */                   public void render(SPRITE_RENDERER r, float ds)
/*     */                   {
/* 200 */                     Debugger.Row row = (Debugger.Row)(Debugger.DebuggerSection.null.access$0(Debugger.DebuggerSection.null.this)).filtered.get(((Integer)ier.get()).intValue());
/* 201 */                     int x1 = this.body.x1() + row.indent * 10;
/* 202 */                     if (row.name == null) {
/* 203 */                       (GCOLOR.T()).H1.bind();
/* 204 */                       (UI.FONT()).S.renderCY(r, x1, this.body.cY(), (CharSequence)row.str);
/*     */                     } else {
/* 206 */                       (GCOLOR.T()).H2.bind();
/* 207 */                       (UI.FONT()).S.renderCY(r, x1, this.body.cY(), row.name);
/* 208 */                       COLOR.unbind();
/* 209 */                       (UI.FONT()).S.renderCY(r, x1 + 400, this.body.cY(), (CharSequence)row.str);
/*     */                     } 
/* 211 */                     COLOR.unbind();
/*     */                   }
/*     */                 };
/*     */             }
/*     */           });
/*     */       
/* 217 */       add((RENDEROBJ)bu.createHeight(height - 8 - this.sp.body().height(), true));
/*     */       
/* 219 */       addRelBody(8, DIR.N, (RENDEROBJ)this.sp);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 225 */       super.render(r, ds);
/* 226 */       this.debugger.clear();
/* 227 */       fill(this.debugger);
/* 228 */       this.filtered.clearSoft();
/*     */       
/* 230 */       if (this.sp.text() == null || this.sp.text().length() == 0) {
/* 231 */         this.filtered.add((Iterable)this.debugger.all);
/*     */       } else {
/* 233 */         for (Debugger.Row rr : this.debugger.all) {
/* 234 */           if (this.sp.text() == null || this.sp.text().length() == 0) {
/* 235 */             this.filtered.add(rr); continue;
/* 236 */           }  if (rr.name != null && Str.containsText(rr.name, (CharSequence)this.sp.text())) {
/* 237 */             this.filtered.add(rr); continue;
/* 238 */           }  if (Str.containsText((CharSequence)rr.str, (CharSequence)this.sp.text()))
/* 239 */             this.filtered.add(rr); 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     protected abstract void fill(Debugger param1Debugger);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\Debugger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */