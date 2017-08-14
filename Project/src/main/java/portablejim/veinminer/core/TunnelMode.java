package portablejim.veinminer.core;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import portablejim.veinminer.VeinMiner;
import portablejim.veinminer.api.Point;
import portablejim.veinminer.configuration.ConfigurationSettings;
import portablejim.veinminer.util.BlockID;

public class TunnelMode {
	
	private Point start;
	private MinerInstance instance;
	
	public TunnelMode(Point startPoint, MinerInstance instance){
		setInstance(instance);
		setStart(startPoint);
		}

	public void setStart(Point start) {
		this.start = start;
	}

	public void setInstance(MinerInstance instance) {
		this.instance = instance;
	}
	
	public void mine(){
		RayTraceResult result = instance.getWorld().rayTraceBlocks(instance.getPlayer().getLookVec(), new Vec3d(start.getX(), start.getY(), start.getZ()));
		EnumFacing facing = EnumFacing.fromAngle(instance.getPlayer().rotationYaw);
		if(instance.getPlayer().rotationPitch < -45.0f){
			facing = EnumFacing.UP;
		}
		else if(instance.getPlayer().rotationPitch > 45.0f){
			facing = EnumFacing.DOWN;
		}
		System.out.println(facing.toString());
		switch (facing) {
		case DOWN:
			mineDown();
			break;
		case UP:
			mineUp();
			break;
		case SOUTH:
			mineSouth();
			break;
		case NORTH:
			mineNorth();
			break;
		case EAST:
			mineEast();
			break;
		case WEST:
			mineWest();
			break;
		}
	}
	
	public void mineEast(){
		int result = 0;
		BlockPos pos;
		for(int x = 0; x < VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); x++){
			for(int z = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); z < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); z++){
				for(int y = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); y < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); y++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
	public void mineWest(){
		int result = 0;
		BlockPos pos;
		for(int x = 0; x > -VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); x--){
			for(int z = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); z < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); z++){
				for(int y = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); y < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); y++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
	public void mineNorth(){
		int result = 0;
		BlockPos pos;
		for(int z = 0; z > -VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); z--){
			for(int x = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); x < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); x++){
				for(int y = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); y < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); y++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
	public void mineSouth(){
		int result = 0;
		BlockPos pos;
		for(int z = 0; z < VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); z++){
			for(int x = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); x < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); x++){
				for(int y = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); y < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); y++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
	public void mineUp(){
		int result = 0;
		BlockPos pos;
		for(int y = 0; y < VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); y++){
			for(int x = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); x < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); x++){
				for(int z = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); z < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); z++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
	public void mineDown(){
		int result = 0;
		BlockPos pos;
		for(int y = 0; y > -VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelLength(); y--){
			for(int x = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth()/2); x < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelWidth() / 2); x++){
				for(int z = -(VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight()/2); z < (VeinMiner.instance.minerServer.getConfigurationSettings().getTunnelHeight() / 2); z++){
					pos = new BlockPos(start.getX() + x,start.getY() + y, start.getZ() + z);
					IBlockState blockState = instance.getWorld().getBlockState(pos);
					BlockID newBlock = new BlockID(blockState);
					if(toolAllowedForBlock(instance.getPlayer().getHeldItemMainhand(), newBlock)){
						instance.getPlayer().interactionManager.tryHarvestBlock(pos);	
					}
					
				}
			}
		}
	}
	
    private boolean toolAllowedForBlock(ItemStack tool, BlockID block) {
        boolean toolAllowed = false;
        ConfigurationSettings settings = VeinMiner.instance.minerServer.getConfigurationSettings();
        for(String type : settings.getToolTypeNames()) {
            if(settings.toolIsOfType(tool, type)) {
                if(VeinMiner.instance.minerServer.getConfigurationSettings().whiteListHasBlockId(type, block)) {
                    toolAllowed = true;
                }
            }
        }
        return toolAllowed;
    }
}
