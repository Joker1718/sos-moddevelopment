/*     */ package init.value;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class Lockable<T>
/*     */ {
/*  20 */   private static CharSequence ¤¤requires = "¤Requires";
/*     */   static {
/*  22 */     D.ts(Lockable.class);
/*     */   }
/*     */   
/*  25 */   final ArrayListGrower<Lock<T>> res = new ArrayListGrower();
/*     */   public final GValueCat<T> values;
/*     */   private static boolean hasSpewed = false;
/*     */   public final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   public final String key;
/*     */   public final SPRITE icon;
/*     */   
/*     */   Lockable(String key, CharSequence name, CharSequence desc, SPRITE icon, GValueCat<T> mm) {
/*  34 */     this.values = mm;
/*  35 */     this.name = name;
/*  36 */     this.icon = icon;
/*  37 */     this.desc = desc;
/*  38 */     this.key = key;
/*     */   }
/*     */   
/*     */   public LIST<Lock<T>> all() {
/*  42 */     return (LIST<Lock<T>>)this.res;
/*     */   }
/*     */   
/*     */   public boolean passes(T t) {
/*  46 */     for (Lock<T> r : all()) {
/*  47 */       if (!r.unlocker.inUnlocked(t))
/*  48 */         return false; 
/*     */     } 
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public double progress(T t) {
/*  54 */     if (all().size() == 0)
/*  55 */       return 1.0D; 
/*  56 */     double d = 0.0D;
/*  57 */     for (Lock<T> r : all()) {
/*  58 */       d += CLAMP.d(r.unlocker.progress(t), 0.0D, 1.0D);
/*     */     }
/*     */     
/*  61 */     return d / all().size();
/*     */   }
/*     */   
/*     */   public boolean hover(GUI_BOX text, T t) {
/*  65 */     return hover(text, t, ¤¤requires);
/*     */   }
/*     */   
/*     */   public boolean hover(GUI_BOX text, T t, CharSequence title) {
/*  69 */     if (all().size() == 0)
/*  70 */       return false; 
/*  71 */     GBox b = (GBox)text;
/*  72 */     b.textLL(title);
/*  73 */     b.NL();
/*     */     
/*  75 */     for (Lock<T> r : all()) {
/*  76 */       r.unlocker.hover(text, t);
/*  77 */       b.NL();
/*     */     } 
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   public void debug(T t) {
/*  83 */     LOG.ln(t);
/*  84 */     for (Lock<T> r : all()) {
/*  85 */       LOG.ln(String.valueOf(r.unlocker.name) + " " + String.valueOf(r.unlocker.name) + " " + r.unlocker.inUnlocked(t));
/*     */     }
/*  87 */     LOG.ln();
/*     */   }
/*     */   
/*     */   public void push(String key, double value, Object path, COMPARATOR comp) {
/*  91 */     RPromise p = new RPromise(key, value, path.toString(), comp);
/*  92 */     this.values.inits.add(p);
/*     */   }
/*     */   
/*     */   public void push(Lock<T> r) {
/*  96 */     this.res.add(r);
/*     */   }
/*     */   
/*     */   public void push(Json json) {
/* 100 */     push("REQUIRES", json);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(String key, Json json) {
/* 109 */     if (!json.has(key))
/*     */       return; 
/* 111 */     json = json.json(key);
/* 112 */     pushPush(json);
/*     */   }
/*     */   
/*     */   public void pushPush(Json json) {
/* 116 */     for (String keyComp : json.keys()) {
/* 117 */       COMPARATOR comp = (COMPARATOR)COMPARATOR.map.get(keyComp, json);
/* 118 */       if (comp != null) {
/* 119 */         Json j = json.json(keyComp);
/* 120 */         for (String k : j.keys()) {
/*     */           
/* 122 */           RPromise p = new RPromise(k, j.d(k), j.path() + ", line" + j.path(), comp);
/* 123 */           this.values.inits.add(p);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   class RPromise
/*     */     implements ACTION {
/*     */     final String key;
/*     */     final double value;
/*     */     final String path;
/*     */     final COMPARATOR comp;
/*     */     
/*     */     RPromise(String key, double value, String path, COMPARATOR comp) {
/* 137 */       this.key = key;
/* 138 */       this.value = value;
/* 139 */       this.path = path;
/* 140 */       this.comp = comp;
/*     */     }
/*     */ 
/*     */     
/*     */     public void exe() {
/* 145 */       if (Lockable.this.values.get(this.key) == null) {
/* 146 */         if (!Lockable.hasSpewed) {
/* 147 */           GAME.Warn(this.path + this.path + "no " + System.lineSeparator() + " named : " + Lockable.this.values.key + " available: " + this.key + System.lineSeparator());
/*     */         } else {
/* 149 */           LOG.err(this.path + this.path + "no " + System.lineSeparator() + " named : " + Lockable.this.values.key);
/*     */         } 
/* 151 */         Lockable.hasSpewed = true;
/*     */         
/* 153 */         Value<T> v = new Value<>(this.key, (SPRITE)(SPRITES.icons()).s.cancel, "unknown", new DOUBLE_O<T>()
/*     */             {
/*     */               public double getD(T t) {
/* 156 */                 return 0.0D;
/*     */               }
/* 158 */             },  false, true);
/*     */         
/* 160 */         Locker<T> un = new Locker.LockerValue<>(this.comp, v, 1.0D, Lockable.this.icon);
/* 161 */         Lock<T> lock = new Lock<>(Lockable.this, un);
/* 162 */         Lockable.this.res.add(lock);
/*     */       }
/*     */       else {
/*     */         
/* 166 */         Value<T> v = Lockable.this.values.get(this.key);
/*     */         
/* 168 */         Locker<T> un = new Locker.LockerValue<>(this.comp, v, this.value, Lockable.this.icon);
/* 169 */         Lock<T> lock = new Lock<>(Lockable.this, un);
/* 170 */         Lockable.this.res.add(lock);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 179 */     this.res.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lockable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */