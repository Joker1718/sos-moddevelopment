/*     */ package init.value;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ 
/*     */ public class Lockers
/*     */ {
/*  17 */   private static CharSequence ¤¤uworld = "Unlocks (World)";
/*  18 */   private static CharSequence ¤¤uIndu = "Unlocks (Subject)";
/*  19 */   private static CharSequence ¤¤uFaction = "Unlocks (Faction)";
/*     */   
/*     */   static {
/*  22 */     D.ts(Lockers.class);
/*     */   }
/*     */   
/*  25 */   private final ArrayListGrower<Lock<?>> locks = new ArrayListGrower();
/*     */   public final CharSequence name;
/*     */   public final SPRITE icon;
/*     */   
/*     */   public Lockers(CharSequence name, SPRITE icon) {
/*  30 */     this.name = name;
/*  31 */     this.icon = icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> void add(GValueCat<T> vv, Json json, DOUBLE_O<T> v) {
/*  36 */     add(vv, "UNLOCKS_" + vv.key, json, v);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> void add(GValueCat<T> vv, String key, Json json, final DOUBLE_O<T> v) {
/*  41 */     if (!json.has(key))
/*     */       return;  byte b; int i;
/*     */     String[] arrayOfString;
/*  44 */     for (i = (arrayOfString = json.values(key)).length, b = 0; b < i; ) { String s = arrayOfString[b];
/*     */       
/*  46 */       Locker<T> locker = new Locker<T>(this.name, this.icon)
/*     */         {
/*     */           public boolean inUnlocked(T t)
/*     */           {
/*  50 */             return (v.getD(t) >= 1.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, T t) {
/*  55 */             Lockers.this.hover(text, v.getD(t));
/*     */           }
/*     */ 
/*     */           
/*     */           public double progress(T t) {
/*  60 */             return v.getD(t);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*  66 */       LPromise<T> p = new LPromise<>();
/*  67 */       p.key = s;
/*  68 */       p.path = json.path() + " line:" + json.path();
/*  69 */       p.locker = locker;
/*  70 */       p.vv = vv;
/*  71 */       vv.LOCK.inits.add(p);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected void hover(GUI_BOX text, double value) {
/*  77 */     GBox b = (GBox)text;
/*  78 */     if (value == 1.0D) {
/*  79 */       b.add((SPRITE)b.text().normalify2().add(this.name));
/*     */     } else {
/*  81 */       b.add((SPRITE)b.text().warnify().add(this.name));
/*     */     } 
/*  83 */     b.NL();
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX text) {
/*  87 */     if (all().size() > 0) {
/*  88 */       GBox b = (GBox)text;
/*  89 */       hover(b, GVALUES.INDU, ¤¤uIndu);
/*  90 */       hover(b, GVALUES.REGION, ¤¤uworld);
/*  91 */       hover(b, GVALUES.FACTION, ¤¤uFaction);
/*  92 */       b.sep();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void hover(GBox b, GValueCat<?> v, CharSequence title) {
/*  98 */     boolean has = false;
/*  99 */     for (Lock<?> l : all()) {
/* 100 */       if (l.lockable.values == v) {
/* 101 */         has = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 105 */     if (has) {
/* 106 */       b.textLL(title);
/* 107 */       b.NL();
/* 108 */       for (Lock<?> l : all()) {
/* 109 */         if (l.lockable.values == v) {
/* 110 */           b.add(l.lockable.icon);
/* 111 */           b.text(l.lockable.name);
/* 112 */           b.NL();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<Lock<?>> all() {
/* 119 */     return (LIST<Lock<?>>)this.locks;
/*     */   }
/*     */   
/*     */   private class LPromise<T>
/*     */     implements ACTION
/*     */   {
/*     */     String key;
/*     */     String path;
/*     */     Locker<T> locker;
/*     */     GValueCat<T> vv;
/*     */     
/*     */     public void exe() {
/* 131 */       Lockable<T> lockable = this.vv.LOCK.get(this.key);
/* 132 */       if (lockable == null) {
/* 133 */         if (!this.vv.LOCK.hasSpewed) {
/* 134 */           GAME.Warn(this.path + this.path + "no UNLOCKABLE " + System.lineSeparator() + " named : " + this.vv.key + " available: " + this.key + System.lineSeparator());
/*     */         } else {
/* 136 */           LOG.ln(this.path + this.path + "no UNLOCKABLE " + System.lineSeparator() + " named : " + this.vv.key);
/*     */         } 
/* 138 */         this.vv.LOCK.hasSpewed = true;
/*     */         return;
/*     */       } 
/* 141 */       Lock<T> lock = new Lock<>(lockable, this.locker);
/* 142 */       lockable.res.add(lock);
/* 143 */       Lockers.this.locks.add(lock);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lockers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */