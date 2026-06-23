/*     */ package init.type;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.Serializable;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ 
/*     */ public final class HGROUP implements MAPPED {
/*     */   private static LIST<HGROUP> ALL;
/*     */   private static LIST<HGROUP> CIT;
/*     */   private static LIST<HGROUP> SLAVE;
/*     */   private static RMAPS<HGROUP> MAP;
/*     */   public final HCLASS type;
/*     */   public final Race race;
/*     */   public final SPRITE icon;
/*     */   public final String name;
/*     */   public final int index;
/*     */   public final String key;
/*     */   
/*     */   static void init() {
/*  29 */     ArrayListGrower<HGROUP> l = new ArrayListGrower();
/*  30 */     ArrayListGrower<HGROUP> ll = new ArrayListGrower();
/*  31 */     for (Race r : RACES.all()) {
/*  32 */       HGROUP g = new HGROUP(l.size(), HCLASSES.SLAVE(), r);
/*  33 */       l.add(g);
/*  34 */       ll.add(g);
/*     */     } 
/*  36 */     SLAVE = (LIST<HGROUP>)ll;
/*  37 */     ll = new ArrayListGrower();
/*  38 */     for (Race r : RACES.all()) {
/*  39 */       HGROUP g = new HGROUP(l.size(), HCLASSES.CITIZEN(), r);
/*  40 */       l.add(g);
/*  41 */       ll.add(g);
/*     */     } 
/*  43 */     CIT = (LIST<HGROUP>)ll;
/*  44 */     ALL = (LIST<HGROUP>)l;
/*  45 */     MAP = new RMAPS("HGROUP", (LIST)l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<HGROUP> all() {
/*  56 */     return ALL;
/*     */   }
/*     */   
/*     */   public static HGROUP get(HCLASS c, Race r) {
/*  60 */     if (c == HCLASSES.SLAVE())
/*  61 */       return (HGROUP)SLAVE.get(r.index()); 
/*  62 */     if (c == HCLASSES.CITIZEN()) {
/*  63 */       return (HGROUP)CIT.get(r.index());
/*     */     }
/*  65 */     return null;
/*     */   }
/*     */   
/*     */   public static HGROUP get(Humanoid h) {
/*  69 */     return get(h.indu());
/*     */   }
/*     */   
/*     */   public static HGROUP get(Induvidual i) {
/*  73 */     return get(i.clas(), i.race());
/*     */   }
/*     */   
/*     */   public static RMAPS<HGROUP> MAP() {
/*  77 */     return MAP;
/*     */   }
/*     */   
/*     */   private HGROUP(int index, HCLASS t, Race r) {
/*  81 */     this.type = t;
/*  82 */     this.race = r;
/*  83 */     this.index = index;
/*  84 */     this.key = t.key + "_" + t.key;
/*  85 */     this.name = String.valueOf(r.info.names) + " (" + String.valueOf(r.info.names) + ")";
/*  86 */     this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  90 */           if (HGROUP.this.race == null || HGROUP.this.race.appearance() == null || (HGROUP.this.race.appearance()).icon == null)
/*     */             return; 
/*  92 */           double scale = (Y2 - Y1) / height();
/*  93 */           int x2 = (int)(X1 + (HGROUP.this.race.appearance()).icon.width() * scale);
/*  94 */           (HGROUP.this.race.appearance()).icon.render(rr, X1, x2, Y1, (int)(Y1 + (HGROUP.this.race.appearance()).icon.height() * scale));
/*  95 */           x2 = (int)(x2 - 6.0D * scale);
/*  96 */           HGROUP.this.type.iconSmall().render(rr, x2, (int)(x2 + HGROUP.this.type.iconSmall().width() * scale), Y1, (int)(Y1 + HGROUP.this.type.iconSmall().width() * scale));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 107 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     return String.valueOf(this.race.info.name) + " " + String.valueOf(this.race.info.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 117 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface HTypeBits
/*     */   {
/*     */     default boolean is(HGROUP type) {
/* 124 */       if (type == null)
/* 125 */         return false; 
/* 126 */       return is(type.index);
/*     */     }
/*     */     
/*     */     boolean is(int param1Int);
/*     */     
/*     */     default boolean is(Humanoid h) {
/* 132 */       if ((h.indu().clas()).player)
/* 133 */         return is(HGROUP.get(h)); 
/* 134 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class HTypeBitsImp implements HTypeBits, Serializable {
/*     */     private static HTypeBitsImp[] specific;
/*     */     private static final long serialVersionUID = 1L;
/*     */     private int[] data;
/*     */     
/*     */     public static HGROUP.HTypeBits specific(HGROUP t) {
/* 144 */       if (specific == null) {
/* 145 */         specific = new HTypeBitsImp[HGROUP.all().size()];
/* 146 */         for (int i = 0; i < HGROUP.all().size(); i++) {
/* 147 */           specific[i] = new HTypeBitsImp(false);
/* 148 */           specific[i].set((HGROUP)HGROUP.all().get(i));
/*     */         } 
/*     */       } 
/* 151 */       return specific[t.index];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public HTypeBitsImp(boolean everyone) {
/* 162 */       if (everyone)
/* 163 */         setEveryone(); 
/*     */     }
/*     */     
/*     */     private int[] bits() {
/* 167 */       if (this.data == null) {
/* 168 */         this.data = Alloc.ii((int)Math.ceil(HGROUP.all().size() / 32.0D));
/* 169 */       } else if (this.data.length != Math.ceil(HGROUP.all().size() / 32.0D)) {
/* 170 */         this.data = Alloc.ii((int)Math.ceil(HGROUP.all().size() / 32.0D));
/*     */       } 
/* 172 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int index) {
/* 177 */       int ii = index >>> 5;
/* 178 */       int m = 1 << (index & 0x1F);
/* 179 */       return ((bits()[ii] & m) != 0);
/*     */     }
/*     */     
/*     */     public HTypeBitsImp set(HGROUP type) {
/* 183 */       int index = type.index;
/* 184 */       int ii = index >>> 5;
/* 185 */       int m = 1 << (index & 0x1F);
/* 186 */       bits()[ii] = bits()[ii] | m;
/*     */       
/* 188 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp copy(HGROUP.HTypeBits other) {
/* 192 */       clear();
/* 193 */       for (int i = 0; i < HGROUP.all().size(); i++) {
/* 194 */         if (other.is(i))
/* 195 */           set((HGROUP)HGROUP.all().get(i)); 
/*     */       } 
/* 197 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp setEveryone() {
/* 201 */       int[] bits = bits();
/* 202 */       for (int i = 0; i < bits.length; i++) {
/* 203 */         bits[i] = -1;
/*     */       }
/* 205 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp clear(HGROUP type) {
/* 209 */       int index = type.index;
/* 210 */       int ii = index >>> 5;
/* 211 */       int m = 1 << (index & 0x1F);
/* 212 */       bits()[ii] = bits()[ii] & (m ^ 0xFFFFFFFF);
/* 213 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp clear() {
/* 217 */       int[] bits = bits();
/* 218 */       for (int i = 0; i < bits.length; i++) {
/* 219 */         bits[i] = 0;
/*     */       }
/* 221 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HGROUP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */