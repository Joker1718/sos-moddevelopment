/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.PlayerColors;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Floor
/*     */   implements MAPPED
/*     */ {
/*     */   private int amount;
/*     */   public final PlayerColors.PlayerColor tint;
/*     */   public CharSequence name;
/*     */   public final CharSequence desc;
/*     */   public final boolean isRoad;
/* 560 */   private final double[] envValues = new double[(SETT.ENV()).map.all().size()];
/*     */   public final AVAILABILITY speed;
/*     */   public final double durability;
/*     */   public final TILE_SHEET sheet;
/*     */   public final RESOURCE resource;
/*     */   public final int resAmount;
/*     */   protected final int code;
/*     */   private final Icon icon;
/*     */   private int indexroad;
/*     */   public final String key;
/*     */   public final boolean isGrass;
/*     */   public final Lockable<Faction> reqs;
/* 572 */   private double[] preference = new double[RACES.all().size()];
/*     */   
/*     */   protected Floor(LISTE<Floor> all, String key, Json data, Json text) throws IOException {
/* 575 */     this.code = all.add(this);
/* 576 */     this.sheet = SPRITES.GAME().raw((SheetType)SheetType.sTex, data);
/* 577 */     this.key = key;
/*     */     
/* 579 */     this.isRoad = data.has("ROAD");
/* 580 */     this.isGrass = data.bool("IS_GRASS", false);
/*     */     
/* 582 */     this.icon = new Icon((SPRITE)new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 586 */             int w = (X2 - X1) / 2;
/* 587 */             int h = (Y2 - Y1) / 2;
/* 588 */             int scale = (X2 - X1) / width();
/* 589 */             for (int y = 0; y < 2; y++) {
/* 590 */               for (int x = 0; x < 2; x++) {
/* 591 */                 int i = y * 2 + x;
/* 592 */                 (Floors.Floor.access$0(Floors.Floor.this)).extra.icon.render(r, i, X1 + x * w, X1 + x * w + w, Y1 + y * h, Y1 + y * h + h);
/* 593 */                 Floors.Floor.this.tint().bind();
/* 594 */                 (Floors.Floor.access$0(Floors.Floor.this)).extra.icon.renderTextured(Floors.Floor.this.sheet.getTexture(i), i + 4, X1 + x * w, Y1 + y * h, scale);
/* 595 */                 COLOR.unbind();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 601 */     if (this.isRoad) {
/* 602 */       Json road = data.json("ROAD");
/* 603 */       this.name = text.text("NAME");
/* 604 */       this.desc = text.text("DESC");
/* 605 */       (SETT.ENV()).map.rmap.readFill(this.envValues, road, 1.0D);
/* 606 */       this.speed = AVAILABILITY.ROADS[road.i("SPEED", 0, AVAILABILITY.ROADS.length - 1)];
/* 607 */       this.durability = road.d("DURABILITY", 0.0D, 1.0D);
/* 608 */       this.resource = (RESOURCE)RESOURCES.map().readTry(road);
/* 609 */       if (road.has("RESOURCE")) {
/* 610 */         this.resAmount = road.i("RESOURCE_AMOUNT");
/*     */       } else {
/*     */         
/* 613 */         this.resAmount = 0;
/*     */       } 
/* 615 */       this.reqs = GVALUES.FACTION.LOCK.push("FLOOR_" + key, this.name, this.desc, (SPRITE)this.icon);
/* 616 */       RACES.map().readFill("PREFERENCE", this.preference, road, 0.0D, 1.0D);
/*     */     } else {
/* 618 */       this.name = String.valueOf(Dic.¤¤floor) + "#" + String.valueOf(Dic.¤¤floor);
/* 619 */       this.desc = "";
/* 620 */       this.durability = 1.0D;
/* 621 */       this.resource = null;
/* 622 */       this.resAmount = 0;
/* 623 */       this.speed = AVAILABILITY.ROAD0;
/* 624 */       this.reqs = GVALUES.FACTION.LOCK.empty;
/*     */     } 
/*     */ 
/*     */     
/* 628 */     this.tint = new PlayerColors.PlayerColor(new ColorImp(data, "COLOR_MASK"), "FLOOR_" + key, Dic.¤¤floor, this.name);
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexRoad() {
/* 633 */     return this.indexroad;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeFixed(int tx, int ty) {
/* 638 */     place(tx, ty);
/*     */     
/* 640 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 641 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 642 */       if (Floors.this.getter.is(tx, ty, d)) {
/* 643 */         ((Floor)Floors.this.getter.get(tx, ty, d)).place(tx + d.x(), ty + d.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void place(int tx, int ty) {
/* 650 */     Floor old = (Floor)Floors.this.getter.get(tx, ty);
/*     */ 
/*     */     
/* 653 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/*     */       return;
/*     */     }
/* 656 */     if (old == null) {
/* 657 */       Floors.this.square.set(tx, ty, false);
/*     */     }
/* 659 */     int d = 0;
/*     */     
/* 661 */     if (SETT.TERRAIN().get(tx, ty).roofIs() || (SETT.ROOMS()).map.is(tx, ty)) {
/* 662 */       d = 15;
/*     */     } else {
/* 664 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 665 */         DIR dir = (DIR)DIR.ORTHO.get(i);
/* 666 */         Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get(tx, ty, dir);
/* 667 */         if (t instanceof TBuilding.Wall) {
/* 668 */           TBuilding.Wall w = (TBuilding.Wall)t;
/* 669 */           if (w.getDia(tx + dir.x(), ty + dir.y()))
/* 670 */             d |= ((DIR)DIR.ORTHO.get(i)).mask(); 
/*     */         } 
/* 672 */         if (!SETT.IN_BOUNDS(tx, ty, dir) || Floors.this.getter.is(tx, ty, dir) || SETT.TERRAIN().get(tx, ty, dir) instanceof settlement.tilemap.terrain.TFortification.Tile || (SETT.ROOMS()).map.is(tx, ty, dir)) {
/* 673 */           d |= ((DIR)DIR.ORTHO.get(i)).mask();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 682 */     if (old == this) {
/* 683 */       int deg = Floors.this.tiles[ty * SETT.TWIDTH + tx] & 0xF0;
/* 684 */       d |= deg;
/*     */     } 
/*     */     
/* 687 */     Floors.this.tiles[ty * SETT.TWIDTH + tx] = (byte)d;
/* 688 */     Floors.this.types.set(ty * SETT.TWIDTH + tx, this.code + 1);
/* 689 */     if (old != this) {
/* 690 */       SETT.TILE_MAP().miniCUpdate(tx, ty);
/*     */     }
/* 692 */     (SETT.GRASS()).currentI.set(tx, ty, 0);
/* 693 */     (SETT.PATH()).availability.updateAvailability(tx, ty);
/* 694 */     SETT.MAINTENANCE().setChanged(tx, ty);
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/* 698 */     return this.name;
/*     */   }
/*     */   
/*     */   public boolean isPlacable(int x, int y) {
/* 702 */     return true;
/*     */   }
/*     */   
/*     */   public Icon getIcon() {
/* 706 */     return this.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 711 */     return this.code;
/*     */   }
/*     */   
/*     */   public double envValue(SettEnvMap.SettEnv e, int tile) {
/* 715 */     return (Floors.this.degrade.get(tile) < 1.0D) ? this.envValues[e.index()] : 0.0D;
/*     */   }
/*     */   
/*     */   public double envValue(SettEnvMap.SettEnv e) {
/* 719 */     return this.envValues[e.index()];
/*     */   }
/*     */   
/*     */   public COLOR tint() {
/* 723 */     if (this.isGrass)
/* 724 */       return SETT.GRASS().color(0); 
/* 725 */     return (COLOR)this.tint.color;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 730 */     return this.key;
/*     */   }
/*     */   
/*     */   public double pref(Race race) {
/* 734 */     return this.preference[race.index()];
/*     */   }
/*     */   
/*     */   public void prefSet(Race race, double pref) {
/* 738 */     this.preference[race.index] = pref;
/*     */   }
/*     */   
/*     */   public int amountPlaced() {
/* 742 */     return this.amount;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Floors$Floor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */