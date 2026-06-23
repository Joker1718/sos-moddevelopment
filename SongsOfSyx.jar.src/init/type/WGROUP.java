/*     */ package init.type;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WGROUP
/*     */   implements MAPPED
/*     */ {
/*     */   private static LIST<WGROUP> ALL;
/*     */   private static RMAPS<WGROUP> MAP;
/*  26 */   private static final int[] toIndex = Alloc.ii(HTYPES.ALL().size());
/*     */   public final HTYPE type;
/*     */   
/*     */   static void init() {
/*  30 */     ArrayListGrower<HTYPE> l = new ArrayListGrower();
/*  31 */     for (HTYPE t : HTYPES.ALL()) {
/*  32 */       if (t.isWorks())
/*  33 */         l.add(t); 
/*  34 */     }  ArrayList<WGROUP> all = new ArrayList(l.size() * RACES.all().size());
/*  35 */     Arrays.fill(toIndex, -1);
/*  36 */     for (int ci = 0; ci < l.size(); ci++) {
/*  37 */       toIndex[((HTYPE)l.get(ci)).index()] = ci;
/*  38 */       for (Race r : RACES.all()) {
/*  39 */         all.add(new WGROUP(ci * RACES.all().size() + r.index, (HTYPE)l.get(ci), r));
/*     */       }
/*     */     } 
/*  42 */     ALL = (LIST<WGROUP>)all;
/*  43 */     MAP = new RMAPS("EGROUP", (LIST)all);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Race race;
/*     */   public final SPRITE icon;
/*     */   public final String name;
/*     */   public final int index;
/*     */   public final String key;
/*     */   
/*     */   public static LIST<WGROUP> all() {
/*  54 */     return ALL;
/*     */   }
/*     */   
/*     */   public static WGROUP get(HTYPE c, Race r) {
/*  58 */     int ci = toIndex[c.index()];
/*  59 */     if (ci < 0)
/*  60 */       return null; 
/*  61 */     return (WGROUP)ALL.get(ci * RACES.all().size() + r.index);
/*     */   }
/*     */   
/*     */   public static WGROUP get(Humanoid h) {
/*  65 */     return get(h.indu());
/*     */   }
/*     */   
/*     */   public static WGROUP get(Induvidual i) {
/*  69 */     return get(i.hType(), i.race());
/*     */   }
/*     */   
/*     */   public static RMAPS<WGROUP> MAP() {
/*  73 */     return MAP;
/*     */   }
/*     */   
/*     */   private WGROUP(int index, HTYPE t, Race r) {
/*  77 */     this.type = t;
/*  78 */     this.race = r;
/*  79 */     this.index = index;
/*  80 */     this.key = t.key + "_" + t.key;
/*  81 */     this.name = String.valueOf(r.info.names) + " (" + String.valueOf(r.info.names) + ")";
/*  82 */     this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  86 */           if (WGROUP.this.race == null || WGROUP.this.race.appearance() == null || (WGROUP.this.race.appearance()).icon == null)
/*     */             return; 
/*  88 */           double scale = (Y2 - Y1) / height();
/*  89 */           int x2 = (int)(X1 + (WGROUP.this.race.appearance()).icon.width() * scale);
/*  90 */           (WGROUP.this.race.appearance()).icon.render(rr, X1, x2, Y1, (int)(Y1 + (WGROUP.this.race.appearance()).icon.height() * scale));
/*  91 */           x2 = (int)(x2 - 6.0D * scale);
/*  92 */           WGROUP.this.type.CLASS.iconSmall().render(rr, x2, (int)(x2 + WGROUP.this.type.CLASS.iconSmall().width() * scale), Y1, (int)(Y1 + WGROUP.this.type.CLASS.iconSmall().width() * scale));
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
/* 103 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     return String.valueOf(this.race.info.name) + " " + String.valueOf(this.race.info.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 113 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface HTypeBits
/*     */   {
/*     */     default boolean is(WGROUP type) {
/* 120 */       return is(type.index);
/*     */     }
/*     */     
/*     */     boolean is(int param1Int);
/*     */     
/*     */     default boolean is(Humanoid h) {
/* 126 */       return is(WGROUP.get(h));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class HTypeBitsImp implements HTypeBits, Serializable {
/*     */     private static HTypeBitsImp[] specific;
/*     */     private static final long serialVersionUID = 1L;
/*     */     private int[] data;
/*     */     
/*     */     public static WGROUP.HTypeBits specific(WGROUP t) {
/* 136 */       if (specific == null) {
/* 137 */         specific = new HTypeBitsImp[WGROUP.all().size()];
/* 138 */         for (int i = 0; i < WGROUP.all().size(); i++) {
/* 139 */           specific[i] = new HTypeBitsImp(false);
/* 140 */           specific[i].set((WGROUP)WGROUP.all().get(i));
/*     */         } 
/*     */       } 
/* 143 */       return specific[t.index];
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
/* 154 */       if (everyone)
/* 155 */         setEveryone(); 
/*     */     }
/*     */     
/*     */     private int[] bits() {
/* 159 */       if (this.data == null) {
/* 160 */         this.data = Alloc.ii((int)Math.ceil(WGROUP.all().size() / 32.0D));
/* 161 */       } else if (this.data.length != Math.ceil(WGROUP.all().size() / 32.0D)) {
/* 162 */         this.data = Alloc.ii((int)Math.ceil(WGROUP.all().size() / 32.0D));
/*     */       } 
/* 164 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int index) {
/* 169 */       int ii = index >>> 5;
/* 170 */       int m = 1 << (index & 0x1F);
/* 171 */       return ((bits()[ii] & m) != 0);
/*     */     }
/*     */     
/*     */     public HTypeBitsImp set(WGROUP type) {
/* 175 */       int index = type.index;
/* 176 */       int ii = index >>> 5;
/* 177 */       int m = 1 << (index & 0x1F);
/* 178 */       bits()[ii] = bits()[ii] | m;
/*     */       
/* 180 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp copy(WGROUP.HTypeBits other) {
/* 184 */       clear();
/* 185 */       for (int i = 0; i < WGROUP.all().size(); i++) {
/* 186 */         if (other.is(i))
/* 187 */           set((WGROUP)WGROUP.all().get(i)); 
/*     */       } 
/* 189 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp setEveryone() {
/* 193 */       int[] bits = bits();
/* 194 */       for (int i = 0; i < bits.length; i++) {
/* 195 */         bits[i] = -1;
/*     */       }
/* 197 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp clear(WGROUP type) {
/* 201 */       int index = type.index;
/* 202 */       int ii = index >>> 5;
/* 203 */       int m = 1 << (index & 0x1F);
/* 204 */       bits()[ii] = bits()[ii] & (m ^ 0xFFFFFFFF);
/* 205 */       return this;
/*     */     }
/*     */     
/*     */     public HTypeBitsImp clear() {
/* 209 */       int[] bits = bits();
/* 210 */       for (int i = 0; i < bits.length; i++) {
/* 211 */         bits[i] = 0;
/*     */       }
/* 213 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\WGROUP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */