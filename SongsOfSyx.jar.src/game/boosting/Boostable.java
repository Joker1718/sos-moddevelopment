/*     */ package game.boosting;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ public final class Boostable
/*     */   extends INFO implements MAPPED {
/*  16 */   final ArrayListGrower<Booster> all = new ArrayListGrower();
/*  17 */   public final ArrayListGrower<Booster> fGlobal = new ArrayListGrower();
/*     */   
/*     */   private final int index;
/*     */   
/*     */   private byte deadlockCheck;
/*     */   public final double baseValue;
/*     */   public final String key;
/*     */   public final Icon icon;
/*     */   public final SPRITE nativeIcon;
/*     */   public final BoostableCat cat;
/*     */   public final double minValue;
/*     */   static final int htab = 7;
/*     */   
/*     */   public Boostable(int index, String key, double baseValue, CharSequence name, CharSequence desc, SPRITE icon, BoostableCat category, double minValue) {
/*  31 */     super(name, desc);
/*  32 */     this.index = index;
/*  33 */     this.baseValue = baseValue;
/*  34 */     this.key = key;
/*  35 */     this.icon = (icon != null) ? new Icon(16, icon) : (UI.icons()).s.DUMMY;
/*  36 */     this.nativeIcon = (icon != null) ? icon : (SPRITE)(UI.icons()).s.DUMMY;
/*  37 */     this.cat = category;
/*  38 */     this.minValue = minValue;
/*  39 */     this.cat.all.add(this);
/*     */   }
/*     */   
/*     */   public Boostable copy() {
/*  43 */     Boostable b = new Boostable(this.index, this.key, this.baseValue, this.name, this.desc, (SPRITE)this.icon, this.cat, this.minValue);
/*  44 */     b.all.add((Iterable)this.all);
/*  45 */     b.all.add((Iterable)this.all);
/*  46 */     return b;
/*     */   }
/*     */   
/*     */   public LIST<Booster> all() {
/*  50 */     return (LIST<Booster>)this.all;
/*     */   }
/*     */   
/*     */   public double min(Class<? extends BOOSTABLE_O> b) {
/*  54 */     return BUtil.min((LIST)this.all, b, this.baseValue);
/*     */   }
/*     */   
/*     */   public double max(Class<? extends BOOSTABLE_O> b) {
/*  58 */     return BUtil.max((LIST)this.all, b, this.baseValue);
/*     */   }
/*     */   
/*     */   public double added(BOOSTABLE_O t) {
/*  62 */     double padd = this.baseValue;
/*  63 */     double mul = 1.0D;
/*  64 */     for (Booster s : this.all) {
/*  65 */       if (s.isMul && s.get(t) > 1.0D) {
/*  66 */         mul *= s.get(t); continue;
/*     */       } 
/*  68 */       double a = s.get(t);
/*  69 */       if (a > 0.0D) {
/*  70 */         padd += a;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     return CLAMP.d(padd * mul, this.minValue, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public double progress(BOOSTABLE_O b) {
/*  81 */     double min = min((Class)b.getClass());
/*  82 */     double max = max((Class)b.getClass());
/*     */     
/*  84 */     double delta = max - min;
/*  85 */     return CLAMP.d(get(b) / delta, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(BOOSTABLE_O t) {
/*  90 */     if (this.deadlockCheck > 1) {
/*  91 */       throw new RuntimeException("boostable " + 
/*  92 */           this.key + "seems to be deadlocked. Make sure it's not a factor in its own factors");
/*     */     }
/*     */     
/*  95 */     this.deadlockCheck = (byte)(this.deadlockCheck + 1);
/*  96 */     double res = BUtil.value((LIST)this.all, t, this.baseValue, 1.0D, this.minValue);
/*  97 */     this.deadlockCheck = (byte)(this.deadlockCheck - 1);
/*  98 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFactor(BoostSpec f) {
/* 105 */     this.all.add(f.booster);
/*     */   }
/*     */   
/*     */   public void removeFactor(BoostSpec f) {
/* 109 */     this.all.remove(f.booster);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, BOOSTABLE_O f, boolean keepNops) {
/* 113 */     hover(box, f, this.name, keepNops);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverDetailed(GUI_BOX box, BOOSTABLE_O f, CharSequence name, boolean keepNops) {
/* 119 */     BHoverer.hoverDetailed(box, (LIST)this.all, f, name, this.baseValue, keepNops);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, BOOSTABLE_O f, CharSequence name, boolean keepNops) {
/* 123 */     BHoverer.hover(box, (LIST)this.all, f, name, this.baseValue, keepNops);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 128 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 133 */     return this.key;
/*     */   }
/*     */   
/*     */   public boolean contains(Booster booster) {
/* 137 */     String k = "" + booster.isMul + " " + booster.isMul;
/* 138 */     for (int bi = 0; bi < this.all.size(); bi++) {
/* 139 */       Booster b2 = (Booster)this.all.get(bi);
/* 140 */       String k2 = "" + b2.isMul + " " + b2.isMul;
/* 141 */       if (k.equals(k2))
/* 142 */         return true; 
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public void debug(BOOSTABLE_O indu) {
/* 148 */     double add = this.baseValue;
/* 149 */     double sub = 0.0D;
/* 150 */     double mul = 1.0D;
/* 151 */     LOG.ln(String.valueOf(this.name) + " " + String.valueOf(this.name));
/* 152 */     for (Booster f : this.all) {
/* 153 */       double v = f.get(indu);
/* 154 */       if (f.isMul) {
/* 155 */         mul *= v;
/* 156 */       } else if (v < 0.0D) {
/* 157 */         sub -= v;
/*     */       } else {
/* 159 */         add += v;
/* 160 */       }  LOG.ln("" + add * mul - sub + " " + add * mul - sub + " " + String.valueOf(f.info.name) + " " + (f.isMul ? "*" : "+"));
/*     */     } 
/* 162 */     LOG.ln(Double.valueOf(add * mul - sub));
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug() {
/* 167 */     LOG.ln(String.valueOf(this.name) + " " + String.valueOf(this.name));
/* 168 */     for (Booster f : this.all)
/* 169 */       LOG.ln(String.valueOf(f.info.name) + " " + String.valueOf(f.info.name) + " " + (f.isMul ? "*" : "+") + " " + f.from()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\Boostable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */