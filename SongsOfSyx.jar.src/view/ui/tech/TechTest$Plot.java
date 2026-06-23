/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.player.PTech;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCost;
/*     */ import init.value.Lock;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Plot
/*     */ {
/*     */   private final RoomBlueprintImp blue;
/* 134 */   private double prevBo = 0.0D;
/* 135 */   private double prevCost = 0.0D;
/* 136 */   private double bo = 0.0D;
/* 137 */   private double cost = 0.0D;
/*     */   private final COLOR col;
/* 139 */   String tt = "";
/* 140 */   private final ArrayListGrower<TechTest.Line> lines = new ArrayListGrower();
/*     */   
/*     */   private boolean show = false;
/*     */   
/*     */   Plot(RoomBlueprintImp blue) {
/* 145 */     this.blue = blue;
/* 146 */     this.col = (COLOR)COLOR.UNIQUE.getC(blue.index());
/* 147 */     Boostable bo = blue.bonus();
/* 148 */     if (bo == null) {
/*     */       return;
/*     */     }
/* 151 */     Bitmap1D map = new Bitmap1D(TECHS.ALL().size(), false);
/* 152 */     Bitmap1D mapN = new Bitmap1D(TECHS.ALL().size(), false);
/* 153 */     boolean has = true;
/* 154 */     int ii = 0;
/* 155 */     while (has) {
/* 156 */       mapN.clear();
/* 157 */       flush();
/* 158 */       has = false;
/*     */       
/* 160 */       for (TECH t : TECHS.ALL()) {
/* 161 */         TECH.TechRequirement re; if (map.get(t.index()))
/*     */           continue; 
/* 163 */         Iterator<TECH.TechRequirement> iterator = t.requires().iterator(); do { if (!iterator.hasNext())
/*     */           
/*     */           { 
/*     */             
/* 167 */             has = true;
/* 168 */             mapN.set(t.index(), true);
/* 169 */             add(t, ii); break; }  re = iterator.next(); }
/*     */         while (map.get(re.tech.index()));
/* 171 */       }  for (TECH t : TECHS.ALL()) {
/* 172 */         if (mapN.get(t.index()))
/* 173 */           map.set(t.index(), true); 
/*     */       } 
/* 175 */       ii++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void add(TECH t, int ii) {
/* 180 */     if (t.AIAmount == 0.0D) {
/*     */       return;
/*     */     }
/* 183 */     double b = boost(t) + tool(t) + upgrade(t);
/*     */     
/* 185 */     boolean ll = false;
/* 186 */     for (Lock<?> l : (Iterable<Lock<?>>)t.lockers.all()) {
/* 187 */       if (l.lockable.key.equals("ROOM_" + this.blue.key)) {
/* 188 */         ll = true;
/*     */       }
/*     */     } 
/*     */     
/* 192 */     if (b > 0.0D || ll) {
/* 193 */       if (this.tt.length() > 0) {
/* 194 */         this.tt = String.valueOf(this.tt) + " + ";
/*     */       } else {
/* 196 */         this.tt = String.valueOf(this.tt) + " ";
/*     */       } 
/* 198 */       this.tt = String.valueOf(this.tt) + " " + String.valueOf(this.tt) + "(" + String.valueOf(t.name()) + "," + cost(t) + ")";
/* 199 */       this.bo += b;
/* 200 */       this.cost += cost(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private double cost(TECH t) {
/* 206 */     double c = 0.0D;
/* 207 */     for (TechCost tc : t.costs) {
/* 208 */       c += PTech.costTotal(tc, t, t.levelMax);
/*     */     }
/* 210 */     return c;
/*     */   }
/*     */   
/*     */   private double boost(TECH t) {
/* 214 */     for (BoostSpec s : t.boosters.all()) {
/* 215 */       if ((SETT.ROOMS()).bonus.get(s.boostable) == this.blue) {
/* 216 */         return s.booster.to() * t.levelMax;
/*     */       }
/*     */     } 
/*     */     
/* 220 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private double tool(TECH t) {
/* 224 */     for (BoostSpec s : t.boosters.all()) {
/* 225 */       if ((SETT.ROOMS()).employment.equip.boostToTarget(s.boostable) != null) {
/* 226 */         RoomEquip.Target ta = (SETT.ROOMS()).employment.equip.boostToTarget(s.boostable);
/* 227 */         if (ta.blue == this.blue) {
/* 228 */           return 0.1875D * t.levelMax * s.booster.to();
/*     */         }
/*     */       } 
/*     */     } 
/* 232 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private double upgrade(TECH t) {
/* 236 */     for (Lock<?> l : (Iterable<Lock<?>>)t.lockers.all()) {
/* 237 */       String n = l.lockable.key;
/*     */       
/* 239 */       if (n.contains(this.blue.key + "_UPGRADE_")) {
/*     */         
/* 241 */         String[] nn = n.split("_UPGRADE_");
/* 242 */         if (nn.length == 2) {
/* 243 */           RoomBlueprintImp b = (RoomBlueprintImp)(SETT.ROOMS()).collection.tryGet(nn[0].replace("ROOM_", ""));
/* 244 */           if (b == this.blue) {
/* 245 */             int lev = Integer.parseInt(nn[1]);
/*     */             
/* 247 */             if (lev == 1)
/* 248 */               return 0.8D; 
/* 249 */             if (lev == 2)
/* 250 */               return 0.5D; 
/* 251 */             return 0.3D;
/*     */           } 
/* 253 */           return 0.0D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 258 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private void flush() {
/* 262 */     if ((this.bo == 0.0D && this.cost == 0.0D) || this.bo == this.prevBo || this.cost == this.prevCost) {
/*     */       return;
/*     */     }
/* 265 */     double startX = this.prevCost * 0.001D * TechTest.width;
/* 266 */     double startY = this.prevBo * 0.16666666666666666D * TechTest.height;
/*     */     
/* 268 */     TechTest.Line l = new TechTest.Line(this.tt, startX, startY, this.bo, this.cost);
/* 269 */     this.tt = "";
/* 270 */     this.lines.add(l);
/*     */     
/* 272 */     this.prevBo += this.bo;
/* 273 */     this.prevCost += this.cost;
/* 274 */     this.bo = 0.0D;
/* 275 */     this.cost = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(SPRITE_RENDERER r) {
/* 280 */     if (!this.show)
/*     */       return; 
/* 282 */     for (TechTest.Line l : this.lines)
/* 283 */       l.render(r, TechTest.access$0(TechTest.this).x1(), TechTest.access$0(TechTest.this).y2(), this.col); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\TechTest$Plot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */